package cn.edu.ntu.javase.classloader;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.SecureClassLoader;

/**
 * @author zack <br>
 * @create 2021-03-02 10:26 <br>
 * @project javase <br>
 */
@Slf4j
public class SalaryJarClassLoader extends SecureClassLoader {

  private String jarPath;

  public SalaryJarClassLoader(String jarPath) {
    this.jarPath = jarPath;
  }

  /**
   * @param name
   * @return
   * @throws ClassNotFoundException
   */
  @SneakyThrows
  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {

    String classPath = "jar:file:\\" + jarPath + "!/" + name.replace(".", "\\").concat("class");
    InputStream inputStream = new URL(classPath).openStream();
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int code;
    while ((code = inputStream.read()) != -1) {
      buffer.write(code);
    }

    byte[] b = buffer.toByteArray();

    return defineClass(name, b, 0, b.length);
  }

  /**
   * 在这里打破双亲委派机制
   *
   * @param name
   * @return
   * @throws ClassNotFoundException
   */
  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {

    // 在使用该类的时候, 发现符合规则, 就直接加载, 不走双亲委派机制
    if (name.startsWith("tp.cn.edu.ntu")) {
      return findClass(name);
    }

    return super.loadClass(name);
  }
}
