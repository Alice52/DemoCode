package cn.edu.ntu.springcloud.payment.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zack <br>
 * @create 2020-04-02 23:45 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentApplication.class, args);
  }
}
