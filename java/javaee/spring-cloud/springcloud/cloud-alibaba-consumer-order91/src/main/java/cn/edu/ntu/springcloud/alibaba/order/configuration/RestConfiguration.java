package cn.edu.ntu.springcloud.alibaba.order.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zack <br>
 * @create 2020-04-12 14:09 <br>
 */
@Configuration
public class RestConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate registerRest() {
        return new RestTemplate();
    }
}
