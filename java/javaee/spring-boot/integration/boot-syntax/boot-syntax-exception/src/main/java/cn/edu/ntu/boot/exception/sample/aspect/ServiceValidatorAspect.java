package cn.edu.ntu.boot.exception.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * This component will has side bad effect, unless you add all validate constraints in impl and
 * interface.<br>
 * Please donot use it.
 *
 * @author zack <br>
 * @create 2021-04-25 16:36 <br>
 * @project integration <br>
 */
@Aspect
@Component
@Deprecated
public class ServiceValidatorAspect {

  @Resource private Validator validator;

  /** 只能工作于实现类 */
  @Pointcut("@annotation(org.springframework.validation.annotation.Validated))")
  public void validateMethod() {}

  @Before("validateMethod()")
  public void before(JoinPoint joinPoint) throws ConstraintViolationException {

    Object[] args = joinPoint.getArgs();
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();

    ExecutableValidator execVal = this.validator.forExecutables();
    Set<ConstraintViolation<Object>> result;
    Method methodToValidate = signature.getMethod();

    try {
      // TODO: make it can work by group
      result = execVal.validateParameters(joinPoint.getThis(), methodToValidate, args);
    } catch (IllegalArgumentException ex) {
      methodToValidate =
          BridgeMethodResolver.findBridgedMethod(
              ClassUtils.getMostSpecificMethod(
                  signature.getMethod(), joinPoint.getThis().getClass()));
      result = execVal.validateParameters(joinPoint.getThis(), methodToValidate, args);
    }

    if (!result.isEmpty()) {
      throw new ConstraintViolationException(result);
    }
  }
}
