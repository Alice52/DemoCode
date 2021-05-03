package aop.bean.validation.verification;

import aop.bean.validation.verification.validators.ArgumentsValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ValidationAspect {

    @Pointcut("execution (public * aop.bean.validation.verification.*.*(..))")
    public void allPublicMethods() {}

    @Before("allPublicMethods()")
    public void validateBefore(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature mSignature = (MethodSignature) signature;
        Object[] args = joinPoint.getArgs();

        try {
            ArgumentsValidator.validate(mSignature.getMethod(), args);
        } catch (CustomException exception) {
            throw exception;
        }
    }
}
