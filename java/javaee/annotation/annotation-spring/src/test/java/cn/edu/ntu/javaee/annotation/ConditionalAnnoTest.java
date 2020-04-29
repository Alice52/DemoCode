package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.conditional.ConditionalAnno;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-29 20:30 <br>
 */
@Slf4j

public class ConditionalAnnoTest {
  private ApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(ConditionalAnno.class);

  @Test
  public void testIocContainer() {

    String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
    Arrays.stream(beanNamesForType)
        .forEach(
            x -> {
              log.info(String.valueOf((Person) applicationContext.getBean(x)));
            });
  }
}
