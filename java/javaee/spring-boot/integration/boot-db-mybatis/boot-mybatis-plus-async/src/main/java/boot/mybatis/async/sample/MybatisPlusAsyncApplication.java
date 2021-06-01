package boot.mybatis.async.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zack <br>
 * @create 2021-04-20 16:31 <br>
 * @project boot-mybatis-plus <br>
 */
@EnableAsync
@SpringBootApplication
public class MybatisPlusAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusAsyncApplication.class, args);
    }
}
