package cn.edu.ntu.javaee.springboot.starter.autoconfiguration;

import cn.edu.ntu.javaee.springboot.starter.properties.HelloProperties;
import cn.edu.ntu.javaee.springboot.starter.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-17 16:36 <br>
 * @project springboot <br>
 */
@Configuration
@ConditionalOnProperty(
        prefix = "starter",
        value = {"enable"},
        havingValue = "true")
@EnableConfigurationProperties(HelloProperties.class)
@ComponentScan(basePackages = {"cn.edu.ntu.javaee.springboot.starter"})
public class HelloServiceAutoConfiguration {

    @Resource HelloProperties helloProperties;

    /**
     * also can new HelloService, then put it in ioc container
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);
        return service;
    }
}
