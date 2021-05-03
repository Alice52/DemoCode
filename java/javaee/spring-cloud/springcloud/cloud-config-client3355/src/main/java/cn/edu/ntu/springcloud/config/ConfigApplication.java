package cn.edu.ntu.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * donot marked by @EnableEurekaClient will also can register to eureka.
 *
 * @author zack <br>
 * @create 2020-04-09 23:25 <br>
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
