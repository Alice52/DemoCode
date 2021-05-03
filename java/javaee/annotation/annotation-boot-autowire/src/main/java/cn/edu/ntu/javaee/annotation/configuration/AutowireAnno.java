package cn.edu.ntu.javaee.annotation.configuration;

import cn.edu.ntu.javaee.annotation.common.model.Dog;
import cn.edu.ntu.javaee.annotation.model.Animal3;
import cn.edu.ntu.javaee.annotation.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zack <br>
 * @create 2020-04-30 16:58 <br>
 */
@Configuration
@Slf4j
@ComponentScan({"cn.edu.ntu.javaee.annotation.model"})
public class AutowireAnno {

    @Primary
    @Bean(value = "helloService2")
    public HelloService helloService() {
        HelloService service = new HelloService();
        service.setLabel("2");
        return service;
    }

    @Bean
    public Dog Dog() {
        return new Dog();
    }

    @Bean
    public Animal3 animal3(/*@Autowired*/ Dog dog) {
        Animal3 animal3 = new Animal3();
        animal3.setDog(dog);
        return animal3;
    }
}
