package boot.web.limit.aspect;

import boot.web.limit.annotation.LimitRequest;
import cn.hutool.core.util.NumberUtil;
import com.google.common.util.concurrent.RateLimiter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zack <br>
 * @create 2021-04-12 14:47 <br>
 * @project integration <br>
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class LimitRequestAspect {

    /** 根据请求地址保存不同的令牌桶 */
    private static final Map<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>(16);

    private static String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 切入去点拦截
     *
     * @see LimitRequest
     */
    @Pointcut("@annotation(limitRequest)")
    public void pointCut(LimitRequest limitRequest) {}

    @Around("pointCut(limitRequest)")
    public Object doPoint(ProceedingJoinPoint joinPoint, LimitRequest limitRequest)
            throws Throwable {

        if (limitRequest.count() == 0 || limitRequest.time() == 0) {
            return joinPoint.proceed();
        }

        // 获取 request
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 获取请求 uri
        String uri = request.getRequestURI();
        if (!rateLimiterMap.containsKey(uri)) {
            // 为当前请求创建令牌桶
            rateLimiterMap.put(
                    uri,
                    RateLimiter.create(NumberUtil.div(limitRequest.count(), limitRequest.time())));
        }
        // 根据请求 uri 获取令牌桶
        RateLimiter rateLimiter = rateLimiterMap.get(uri);
        // 获取令牌

        boolean acquire =
                rateLimiter.tryAcquire(
                        limitRequest.acquireTokenTimeout(), limitRequest.acquireTokenTimeUnit());
        if (acquire) {
            // 调用目标方法
            return joinPoint.proceed();
        }
        // 获取不到令牌抛出异常
        log.info("接口: {}, IP: {} - {}", uri, getRemoteIP(request), limitRequest.message());
        throw new RuntimeException(limitRequest.message());
    }
}
