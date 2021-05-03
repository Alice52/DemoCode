package cn.edu.ntu.springcloud.order1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * this uses default client load balance.<br>
 * and rest template need be marked by @LoadBalanced.
 *
 * @author zack <br>
 * @create 2020-04-06 16:04 <br>
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
