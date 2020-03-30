package cn.edu.ntu.springcloud.order1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zack <br>
 * @create 2020-03-10 21:41 <br>
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }
}
