package cn.edu.ntu.javase.classloader;

import cn.edu.ntu.javase.common.model.Person;
import cn.hutool.core.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 22:04 <br>
 */
public class ClassLoaderKind {
  private static final Logger LOG = LoggerFactory.getLogger(ClassLoaderKind.class);

  public static void main(String[] args) {
    Object object = new Object();
    // bootstrap classloader == null
    LOG.info(String.valueOf(object.getClass().getClassLoader()));

    Person person = new Person();
    // bootstrap classloader == null
    LOG.info(String.valueOf(person.getClass().getClassLoader().getParent().getParent()));
    // extension classloader == sun.misc.Launcher$ExtClassLoader@439f5b3d
    LOG.info(String.valueOf(person.getClass().getClassLoader().getParent()));
    // application[system] classloader == sun.misc.Launcher$AppClassLoader@18b4aac2
    LOG.info(String.valueOf(person.getClass().getClassLoader()));
    LOG.info(String.valueOf(ClassLoader.getSystemClassLoader()));
    Assert.isTrue(person.getClass().getClassLoader() == ClassLoader.getSystemClassLoader());
  }
}
