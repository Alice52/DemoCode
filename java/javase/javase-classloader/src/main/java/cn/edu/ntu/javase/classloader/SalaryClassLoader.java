package cn.edu.ntu.javase.classloader;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.security.SecureClassLoader;

/**
 * @author zack <br>
 * @create 2021-03-02 10:26 <br>
 * @project javase <br>
 */
@Slf4j
public class SalaryClassLoader extends SecureClassLoader {

  private String filePath;

  public SalaryClassLoader(String jarPath) {
    this.filePath = jarPath;
  }

  @SneakyThrows
  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {

    String classPath = filePath + name.replace(".", "\\").concat("class");
    FileInputStream inputStream = new FileInputStream(new File(classPath));
    ByteArrayBuffer buffer = new ByteArrayBuffer();
    byte[] b;
    int code;
    while ((code = inputStream.read()) != -1) {
      buffer.write(code);
    }

    b = buffer.getRawData();

    return defineClass(name, b, 0, b.length);
  }
}
