package cn.edu.ntu.springcloud.order1;

import cn.edu.ntu.springcloud.lbrule.CustomLbRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * this contains specify strategy client load balance.<br>
 * and rest template need be marked by @LoadBalanced.
 *
 * @author zack <br>
 * @create 2020-04-06 16:04 <br>
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = CustomLbRule.class)
public class OrderLbApplication {
  private static final Logger LOG = LoggerFactory.getLogger(OrderLbApplication.class);
}
