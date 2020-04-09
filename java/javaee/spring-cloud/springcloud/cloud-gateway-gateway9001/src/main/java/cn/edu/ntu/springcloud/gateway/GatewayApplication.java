package cn.edu.ntu.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * donot marked @EnableEurekaClient annotation, it will also can register to center success.
 *
 * @author zack <br>
 * @create 2020-04-08 22:18 <br>
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }
}
