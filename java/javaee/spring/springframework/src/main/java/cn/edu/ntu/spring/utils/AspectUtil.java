package cn.edu.ntu.spring.utils;

import cn.edu.ntu.spring.constants.Constants;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;

import java.lang.reflect.Field;

/**
 * @author zack
 * @create 2019-10-29 23:41
 * @function
 */
public class AspectUtil {
  public static Logger getTargetLogger(Logger LOGGER, JoinPoint joinPoint) {

    Class<?> target = joinPoint.getTarget().getClass();
    Field[] fields = target.getDeclaredFields();

    boolean isDefaultLogger = Constants.BOOLEAN_FALSE;
    String LogFiled = Constants.STRING_EMPTY;

    for (Field field : fields) {
      String fieldName = field.getName();
      if (fieldName.toUpperCase().contains("LOG")) {
        isDefaultLogger = Constants.BOOLEAN_TRUE;
        LogFiled = fieldName;
        break;
      }
    }

    if (isDefaultLogger && !Constants.STRING_EMPTY.equals(LogFiled)) {
      Logger LOG = null;
      try {
        Field field = target.getDeclaredField(LogFiled);
        field.setAccessible(true);

        LOG = (Logger) field.get(joinPoint.getTarget());
      } catch (NoSuchFieldException e) {
        LOGGER.warn(
            "Get LogFiled[{}] from target ERROR[NoSuchFieldException], message {}", LogFiled, e);
      } catch (IllegalAccessException e) {
        LOGGER.warn(
            "Get LogFiled[{}] from target ERROR[IllegalAccessException], message {}", LogFiled, e);
      }

      return LOG;
    }

    return LOGGER;
  }
}
