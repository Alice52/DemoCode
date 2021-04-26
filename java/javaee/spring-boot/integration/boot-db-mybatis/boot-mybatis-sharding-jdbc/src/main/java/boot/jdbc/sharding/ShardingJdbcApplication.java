package boot.jdbc.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-26 11:47 <br>
 * @project boot-security-shiro <br>
 */
@SpringBootApplication
public class ShardingJdbcApplication {
  public static void main(String[] args) {
    SpringApplication.run(ShardingJdbcApplication.class, args);
  }
}
