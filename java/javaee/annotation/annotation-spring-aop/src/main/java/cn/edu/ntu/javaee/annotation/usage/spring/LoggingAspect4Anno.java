package cn.edu.ntu.javaee.annotation.usage.spring;

import cn.edu.ntu.javaee.annotation.usage.utils.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zack <br>
 * @create 2020-05-01 12:26 <br>
 */
@Slf4j
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect4Anno {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect4Anno.class);

    @Pointcut(value = "execution(* cn.edu.ntu.javaee.annotation.usage.before.proxy.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void preAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);

        LOG.info("Before Advice, exec method {} with args {}", methodName, null);
    }

    @After(value = "pointCut()")
    public void postAdvice(JoinPoint joinPoint) {
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);
        String methodName = joinPoint.getSignature().getName();

        LOG.info("After Advice, exec method {} end", methodName);
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void reAdvice(JoinPoint joinPoint, Object result) {
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);
        String methodName = joinPoint.getSignature().getName();

        LOG.info("Return Advice, exec method {} end and result is {}", methodName, result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void throwingAdvice(JoinPoint joinPoint, Exception ex) {
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);
        String methodName = joinPoint.getSignature().getName();

        LOG.error("Throwing Advice, exec method {} occurs exception {}", methodName, ex);
    }

    // @Around(value = "pointCut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {

        try {
            // PreAdvice
            Object proceed = joinPoint.proceed();
            // ReturnAdvicexec method
        } catch (Throwable throwable) {
            // ThrowingAdvice
        } finally {
            // PostAdvice
        }
    }
}
