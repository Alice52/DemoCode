package cn.edu.ntu.javase.jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author zack <br>
 * @create 2020-04-04 23:41 <br>
 */
public class Oom {
  private static final Logger LOG = LoggerFactory.getLogger(Oom.class);

  // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
  public static void main(String[] args) {
    String str = "for OOM";
    while (true) {
      str += str + new Random().nextInt(88888888) + new Random().nextInt(9999999);
    }
    // byte[] b = new byte[40 * 1024 * 1024];
  }
}
