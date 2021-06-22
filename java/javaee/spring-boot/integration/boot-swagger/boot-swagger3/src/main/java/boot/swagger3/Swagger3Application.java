package boot.swagger3;

import boot.swagger3.config.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-26 10:01 <br>
 * @project boot-job-quartz <br>
 */
@EnableSwagger
@SpringBootApplication
public class Swagger3Application {
    public static void main(String[] args) {
        SpringApplication.run(Swagger3Application.class, args);
    }
}
