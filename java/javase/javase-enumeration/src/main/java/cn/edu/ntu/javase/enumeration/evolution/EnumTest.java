package cn.edu.ntu.javase.enumeration.evolution;

import cn.edu.ntu.javase.enumeration.evolution.enumeration.UserStatus;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author zack <br>
 * @create 2020-01-31 17:35 <br>
 */
public class EnumTest {
  private static final Logger LOG = LoggerFactory.getLogger(EnumTest.class);

  @Test
  public void nameTest() {
    for (UserStatus userStatus : UserStatus.values()) {
      String name = userStatus.name();
      LOG.info("UserStatus: {}", name);

      UserStatus userStatus1 = UserStatus.valueOf(name);
      LOG.info("userStatus {} userStatus1", userStatus == userStatus1 ? "==" : "!=");
    }
  }

  @Test
  public void ordinalTest() {
    for (UserStatus userStatus : UserStatus.values()) {
      int ordinal = userStatus.ordinal();
      LOG.info("UserStatus:" + ordinal);

      UserStatus userStatus1 = UserStatus.values()[ordinal];
      LOG.info("userStatus {} userStatus1", userStatus == userStatus1 ? "==" : "!=");
    }
  }

  @Test
  public void enumTest() {
    LOG.info("Fields");

    for (Field field : UserStatus.class.getDeclaredFields()) {
      LOG.info(field.toString());
    }

    LOG.info("Methods");
    for (Method method : UserStatus.class.getDeclaredMethods()) {
      StringBuilder methodBuilder = new StringBuilder();
      methodBuilder.append(Modifier.toString(method.getModifiers()));
      methodBuilder.append(method.getReturnType()).append(" ").append(method.getName()).append("(");
      Parameter[] parameters = method.getParameters();
      for (int i = 0; i < method.getParameterCount(); i++) {
        Parameter parameter = parameters[i];
        methodBuilder.append(parameter.getType()).append(" ").append(parameter.getName());
        if (i != method.getParameterCount() - 1) {
          methodBuilder.append(",");
        }
      }
      methodBuilder.append(")");
      LOG.info(methodBuilder.toString());
    }
  }
}
