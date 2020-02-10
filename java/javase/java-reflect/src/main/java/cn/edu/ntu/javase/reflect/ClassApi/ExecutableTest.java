package cn.edu.ntu.javase.reflect.ClassApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

/**
 * @author zack <br>
 * @create 2020-02-10 19:58 <br>
 */
public class ExecutableTest {
  private static final Logger LOG = LoggerFactory.getLogger(ExecutableTest.class);

  public static void main(String... args) throws Exception {
    for (Constructor constructor : BeanTest.class.getConstructors()) {
      LOG.info("getName: " + constructor.getName());

      LOG.info("getModifiers: " + Modifier.toString(constructor.getModifiers()));

      LOG.info("getTypeParameters:");
      for (TypeVariable<Constructor> t : constructor.getTypeParameters()) {
        LOG.info("type var:" + t.getName());
      }

      LOG.info("getParameterCount:" + constructor.getParameterCount());

      LOG.info("getParameterTypes:");
      for (Class cls : constructor.getParameterTypes()) {
        LOG.info(cls.getName());
      }

      LOG.info("getExceptionTypes:");
      for (Class cls : constructor.getExceptionTypes()) {
        LOG.info(cls.getName());
      }
    }
  }
}

class BeanTest {
  private String id;

  public <T, R> BeanTest(String id) throws IllegalArgumentException, NotImplementedException {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  private void setId(String id) {
    this.id = id;
  }
}
