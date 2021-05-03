package boot.web.limit.aspect;

import boot.web.limit.annotation.IdempotentRequest;
import boot.web.limit.utils.RequestHolder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zack <br>
 * @create 2021-04-12 17:47 <br>
 * @project integration <br>
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class IdempotentRequestAspect {

    /** <uri, <token, count>> */
    private static final Map<String, ExpiringMap<String, Integer>> map =
            new ConcurrentHashMap<>(16);

    /**
     * 切入去点拦截
     *
     * @see IdempotentRequest
     */
    @Pointcut("@annotation(idempotentRequest)")
    public void pointCut(IdempotentRequest idempotentRequest) {}

    @Around("pointCut(idempotentRequest)")
    public Object doPoint(ProceedingJoinPoint point, IdempotentRequest idempotentRequest)
            throws Throwable {

        HttpServletRequest request = RequestHolder.getCurrentRequest();
        String token = RequestHolder.getCurrentToken();

        ExpiringMap<String, Integer> em =
                map.getOrDefault(
                        request.getRequestURI(),
                        ExpiringMap.builder().variableExpiration().build());
        Integer count = em.getOrDefault(token, 0);

        if (count >= 1) {
            // 超过次数，不执行目标方法
            return null;
        }

        em.put(
                token,
                1,
                ExpirationPolicy.CREATED,
                idempotentRequest.time(),
                idempotentRequest.timeUnit());
        map.put(request.getRequestURI(), em);

        return point.proceed();
    }
}
