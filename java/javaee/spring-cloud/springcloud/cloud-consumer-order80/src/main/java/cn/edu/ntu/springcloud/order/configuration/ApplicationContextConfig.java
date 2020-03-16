package cn.edu.ntu.springcloud.order.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zack <br>
 * @create 2020-03-10 21:45 <br>
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
  public RestTemplate getRestTemplate() {

    return new RestTemplate();
  }
}
