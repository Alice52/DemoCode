package cn.edu.ntu.javaee.annotation.conditional;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.conditional.condition.CustomCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br>
 * @create 2020-04-29 19:24 <br>
 */
@Slf4j
@Configuration
public class ConditionalAnno {

  @Conditional({CustomCondition.class})
  @Bean(value = "alice52")
  public Person injectPerson() {
    return new Person(19, "alice52");
  }

  @Bean(value = "zack")
  public Person injectPerson2() {
    return new Person(190, "zack");
  }
}
