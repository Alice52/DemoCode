package cn.edu.ntu.spring.aop.aspect;

import cn.edu.ntu.spring.utils.AspectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zack
 * @create 2019-10-29 20:57
 * @function this is Aspect class for logging
 */
@Component
@Aspect
@Deprecated
public class LoggingAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

  @Pointcut(value = "execution(* cn.edu.ntu.spring.aop.before.proxy.*.*(..))")
  public void pointCut() {}

  /**
   * @function preAdvice
   * @param joinPoint
   * @apiNote preAdvice cannot obtain result
   */
  @Before("pointCut()")
  public void preAdvice(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    Logger LOG = AspectUtil.getTargetLogger(this.LOGGER, joinPoint);

    LOG.info(
        "Before Advice, exec method {} with args {}",
        methodName,
        getTargetArgs(joinPoint, methodName));
  }

  /**
   * @function postAdvice
   * @param joinPoint
   * @apiNote postAdvice cannot obtain result and will execute always
   */
  @After(value = "pointCut()")
  public void postAdvice(JoinPoint joinPoint) {
    Logger LOG = AspectUtil.getTargetLogger(this.LOGGER, joinPoint);
    String methodName = joinPoint.getSignature().getName();

    LOG.info("After Advice, exec method {} end", methodName);
  }

  /**
   * @functin reAdvice can obtain method result
   * @param joinPoint
   * @param result
   */
  @AfterReturning(value = "pointCut()", returning = "result")
  public void reAdvice(JoinPoint joinPoint, Object result) {
    Logger LOG = AspectUtil.getTargetLogger(this.LOGGER, joinPoint);
    String methodName = joinPoint.getSignature().getName();

    LOG.info("Return Advice, exec method {} end and result is {}", methodName, result);
  }

  /**
   * @function throwingAdvice can specify exception to execute throwingAdvice method
   * @param joinPoint
   * @param ex
   */
  @AfterThrowing(value = "pointCut()", throwing = "ex")
  public void throwingAdvice(JoinPoint joinPoint, Exception ex) {
    Logger LOG = AspectUtil.getTargetLogger(this.LOGGER, joinPoint);
    String methodName = joinPoint.getSignature().getName();

    LOG.error("Throwing Advice, exec method {} occurs exception {}", methodName, ex);
  }

  @Around(value = "pointCut()")
  public void aroundAdvice(ProceedingJoinPoint joinPoint) {

    try {
      // PreAdvice
      Object proceed = joinPoint.proceed();
      // ReturnAdvice
    } catch (Throwable throwable) {
      // ThrowingAdvice
    } finally {
      // PostAdvice
    }
  }

  public static String getTargetArgs(JoinPoint joinPoint, String methodName) {
    // TODO args is object will not specify value
    Object[] args = joinPoint.getArgs();
    Map<String, Object> keyAndValue = new HashMap<>();
    try {
      keyAndValue = getKeyAndValue(args, methodName);
    } catch (Exception e) {
      LOGGER.error("Get getKeyAndValue failed, message {}", e);
    }
    return keyAndValue.toString();
  }

  // TODO return json and argument should be specify
  public static Map<String, Object> getKeyAndValue(Object[] objs, String methodName) {

    Map<String, Object> map = new HashMap<>();

    for (int j = 0; j < objs.length; j++) {

      if (objs[j] == null) {
        map.put("arguments", "EMPTY");
      } else {
        Class<? extends Object> userCla = objs[j].getClass();
        String classType = userCla.getName();

        if (classType.equals("java.lang.String")
            || classType.equals("java.lang.Long")
            || classType.equals("java.lang.Integer")
            || classType.equals("java.lang.Double")
            || classType.equals("java.lang.Boolean")
            || classType.equals("java.lang.Float")
            || classType.equals("java.lang.Character")
            || classType.equals("java.lang.Byte")) {
          map.put("argument[" + (j + 1) + "]", objs[j]);
        } else {
          Field[] fs = userCla.getDeclaredFields();
          for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true);

            try {
              Object val = f.get(objs[j]);
              if (val == null) {
                map.put(f.getName(), objs[j]);
              } else {
                map.put(f.getName(), val.toString());
              }
            } catch (IllegalArgumentException e) {
              LOGGER.warn(
                  "Get args values of method {} ERROR[IllegalArgumentException], message: {}",
                  methodName,
                  e);
            } catch (IllegalAccessException e) {
              LOGGER.warn(
                  "Get args values of method {} ERROR[IllegalAccessException], message: {}",
                  methodName,
                  e);
            }
          }
        }
      }
    }
    return map;
  }
}
