package boot.cache.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-12 10:06 <br>
 * @project integration <br>
 */
@SpringBootApplication
public class RedisLockApplication {
  public static void main(String[] args) {
    SpringApplication.run(RedisLockApplication.class, args);
  }
}
