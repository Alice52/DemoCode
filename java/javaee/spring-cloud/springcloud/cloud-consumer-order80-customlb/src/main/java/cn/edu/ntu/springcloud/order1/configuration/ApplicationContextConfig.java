package cn.edu.ntu.springcloud.order1.configuration;

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
