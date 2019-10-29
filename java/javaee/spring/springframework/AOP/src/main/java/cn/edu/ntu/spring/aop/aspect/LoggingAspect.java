package cn.edu.ntu.spring.aop.aspect;

import cn.edu.ntu.spring.utils.AspectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zack
 * @create 2019-10-29 20:57
 * @function this is Aspect class for logging
 */
@Component
@Aspect
public class LoggingAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

  @Before(value = "execution(* cn.edu.ntu.spring.aop.before.proxy.*.*(..))")
  public void preAdvice(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    Logger LOG = AspectUtil.getTargetLogger(this.LOGGER, joinPoint);

    LOG.info(
        "Before Advice, exec method {} with args {}",
        methodName,
        getTargetArgs(joinPoint, methodName));
  }

  public static String getTargetArgs(JoinPoint joinPoint, String methodName) {
    // TODO args is object will not specify value
    Object[] args = joinPoint.getArgs();
    Map<String, Object> keyAndValue = getKeyAndValue(args, methodName);

    return keyAndValue.toString();
  }

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
