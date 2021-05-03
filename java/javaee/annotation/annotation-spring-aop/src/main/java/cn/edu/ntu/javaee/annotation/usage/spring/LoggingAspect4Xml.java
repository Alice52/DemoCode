package cn.edu.ntu.javaee.annotation.usage.spring;

import cn.edu.ntu.javaee.annotation.usage.utils.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-05-01 12:26 <br>
 */
@Slf4j
@Component
public class LoggingAspect4Xml {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect4Xml.class);

    /**
     * @function preAdvice
     * @param joinPoint
     * @apiNote preAdvice cannot obtain result
     */
    public void preAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);

        LOG.info("Before Advice, exec method {} with args {}", methodName, null);
    }

    /**
     * postAdvice
     *
     * @param joinPoint
     * @apiNote postAdvice cannot obtain result and will execute always
     */
    public void postAdvice(JoinPoint joinPoint) {
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);
        String methodName = joinPoint.getSignature().getName();

        LOG.info("After Advice, exec method {} end", methodName);
    }

    /**
     * reAdvice can obtain method result
     *
     * @param joinPoint
     * @param result
     */
    public void reAdvice(JoinPoint joinPoint, Object result) {
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);
        String methodName = joinPoint.getSignature().getName();

        LOG.info("Return Advice, exec method {} end and result is {}", methodName, result);
    }

    /**
     * throwingAdvice can specify exception to execute throwingAdvice method
     *
     * @param joinPoint
     * @param ex
     */
    public void throwingAdvice(JoinPoint joinPoint, Exception ex) {
        Logger LOG = AspectUtil.getTargetLogger(LOGGER, joinPoint);
        String methodName = joinPoint.getSignature().getName();

        LOG.error("Throwing Advice, exec method {} occurs exception {}", methodName, ex);
    }

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
