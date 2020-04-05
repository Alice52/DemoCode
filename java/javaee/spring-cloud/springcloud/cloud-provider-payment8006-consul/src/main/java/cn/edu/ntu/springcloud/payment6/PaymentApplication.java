package cn.edu.ntu.springcloud.payment6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zack <br>
 * @create 2020-03-30 23:05 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {
  public static void main(String[] args) {
    SpringApplication.run(PaymentApplication.class, args);
  }
}
