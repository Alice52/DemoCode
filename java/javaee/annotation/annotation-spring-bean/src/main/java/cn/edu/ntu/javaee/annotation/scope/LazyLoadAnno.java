package cn.edu.ntu.javaee.annotation.scope;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author zack <br>
 * @create 2020-04-29 19:21 <br>
 */
@Configuration
public class LazyLoadAnno {

  /**
   * donot created when IOC container created, created in first used
   *
   * @return Person
   */
  @Lazy
  @Bean(value = "person")
  public Person injectPerson() {
    return new Person(19, "alice52");
  }
}
