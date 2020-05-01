package cn.edu.ntu.javaee.annotation.usage.utils;

import cn.hutool.core.util.StrUtil;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author zack <br>
 * @create 2020-05-01 12:41 <br>
 */
@Deprecated
public class AspectUtil {

  /**
   * Get aspect class logger. <br>
   * Deprecated due to we log CutPoint. <br>
   *
   * @param LOGGER
   * @param joinPoint
   * @return Logger
   */
  @Deprecated
  public static Logger getTargetLogger(Logger LOGGER, JoinPoint joinPoint) {

    Class<?> target = joinPoint.getTarget().getClass();
    Field[] fields = target.getDeclaredFields();

    boolean isDefaultLogger = Boolean.FALSE;
    String LogFiled = StrUtil.EMPTY;

    for (Field field : fields) {
      String fieldName = field.getName();
      if (fieldName.toUpperCase().contains("LOG")) {
        isDefaultLogger = Boolean.TRUE;
        LogFiled = fieldName;
        break;
      }
    }

    if (isDefaultLogger && !StrUtil.EMPTY.equals(LogFiled)) {
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
