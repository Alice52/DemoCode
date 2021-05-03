package cn.edu.ntu.javaee.annotation.bean;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br>
 * @create 2020-04-29 20:38 <br>
 */
@Configuration
public class BeanAnno {

    @Bean(value = "person")
    public Person injectPerson() {
        return new Person(19, "alice52");
    }

    /**
     * This method will not execute due to IOC container already has person bean<br>
     *
     * @return Person
     */
    @Bean(value = "person")
    public Person injectPerson2() {
        return new Person(190, "alice520");
    }

    /**
     * This method will execute and put object to IOC container due to it has different bean name.
     * <br>
     *
     * @return Person
     */
    @Bean(value = "alice52")
    public Person injectPerson3() {
        return new Person(190, "alice52");
    }
}
