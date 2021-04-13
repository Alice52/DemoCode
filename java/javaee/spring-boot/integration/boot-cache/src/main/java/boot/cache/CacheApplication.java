package boot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zack <br>
 * @create 2021-01-04 20:59 <br>
 * @project springboot <br>
 */
@MapperScan("boot.cache.sample.mapper")
@SpringBootApplication
public class CacheApplication {
  public static void main(String[] args) {
    SpringApplication.run(CacheApplication.class, args);
  }
}
