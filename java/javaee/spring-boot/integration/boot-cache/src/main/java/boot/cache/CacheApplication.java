package boot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * // TODO: this module need modify
 *
 * <pre>
 *     2. redis cache serial
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-04 20:59 <br>
 * @project springboot <br>
 */
@SpringBootApplication
@EnableCaching
public class CacheApplication {
  public static void main(String[] args) {
    SpringApplication.run(CacheApplication.class, args);
  }
}
