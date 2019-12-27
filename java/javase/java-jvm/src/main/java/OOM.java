import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author zack
 * @create 2019-12-14 21:55
 * @function
 */
public class OOM {
  private static final Logger LOG = LoggerFactory.getLogger(OOM.class);

  // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
  public static void main(String[] args) {
     String str = "for OOM";
     while (true) {
       str += str + new Random().nextInt(88888888) + new Random().nextInt(9999999);
     }

    // byte[] b = new byte[40 * 1024 * 1024];
  }
}
