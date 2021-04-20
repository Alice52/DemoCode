package boot.mybatis.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zack <br>
 * @create 2021-04-20 16:17 <br>
 * @project integration <br>
 */
@SpringBootApplication
@ComponentScan("boot.mybatis.common.config")
public class MybatisPlusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisPlusApplication.class, args);
  }
}
