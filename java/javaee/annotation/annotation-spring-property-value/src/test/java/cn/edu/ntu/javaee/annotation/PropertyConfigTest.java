package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.configuration.PropertyConfig;
import cn.edu.ntu.javaee.annotation.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-30 15:52 <br>
 */
@Slf4j
public class PropertyConfigTest {

  private ApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(PropertyConfig.class);

  @Test
  public void testBeanInitAndDestroy() {
    Cat cat = applicationContext.getBean(Cat.class);
    log.info(String.valueOf(cat));

    String weight = Cat.getWeight();
    log.info(weight);
  }

  @Test
  public void testGetBeansFromIoc() {
    String[] definitionNames = applicationContext.getBeanDefinitionNames();
    Arrays.stream(definitionNames).forEach(System.out::println);
  }
}
