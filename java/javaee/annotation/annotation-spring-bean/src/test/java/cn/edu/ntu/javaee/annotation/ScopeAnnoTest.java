package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.scope.ScopeAnno;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-29 18:54 <br>
 */
@Slf4j
public class ScopeAnnoTest {

  private ApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(ScopeAnno.class);

  @Test
  public void testIocContainer() {

    Person person = applicationContext.getBean(Person.class);
    log.info(String.valueOf(person));
  }

  @Test
  /** The bean name is @Bean method default, and @Bean value. */
  public void testGetBeanName() {
    String[] names = applicationContext.getBeanNamesForType(Person.class);
    Arrays.stream(names).forEach(System.out::println);
  }

  @Test
  public void testIocObjectsForComponentScanConfig() {
    String[] definitionNames = applicationContext.getBeanDefinitionNames();

    Arrays.stream(definitionNames).forEach(System.out::println);
  }
}
