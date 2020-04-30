package cn.edu.ntu.javaee.xml;

import cn.edu.ntu.javaee.annotation.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-30 16:05 <br>
 */
@Slf4j
public class PropertyTest {

  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

  @Test
  public void testBeanInitAndDestroy() {
    Cat cat = applicationContext.getBean(Cat.class);
    log.info(String.valueOf(cat));
  }

  @Test
  public void testGetBeansFromIoc() {
    String[] definitionNames = applicationContext.getBeanDefinitionNames();
    Arrays.stream(definitionNames).forEach(System.out::println);
  }
}
