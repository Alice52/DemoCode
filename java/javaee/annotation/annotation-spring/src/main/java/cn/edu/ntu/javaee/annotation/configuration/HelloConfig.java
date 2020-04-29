package cn.edu.ntu.javaee.annotation.configuration;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <code>@ComponentScan</code> includeFilters usage is: useDefaultFilters = false. <br>
 *
 * @author zack <br>
 * @create 2020-04-29 16:33 <br>
 */
@Configuration
public class HelloConfig {

  /**
   * method name is bean name in IOC container, but if specify value, which will be bean name.</br>
   *
   * @return Person
   */
  @Bean(value = "person")
  public Person injectPerson() {
    return new Person(19, "alice52");
  }
}
