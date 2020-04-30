package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.interf.BeanInitAndDestroyInter;
import cn.edu.ntu.javaee.annotation.interf.model.Dog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-30 12:36 <br>
 */
@Slf4j
public class BeanInitAndDestroyInterTest {
  private ApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(BeanInitAndDestroyInter.class);

  @Test
  public void testBeanInitAndDestroy() {
    Dog dog = applicationContext.getBean(Dog.class);
    log.info(String.valueOf(dog));

    AnnotationConfigApplicationContext context =
        (AnnotationConfigApplicationContext) this.applicationContext;
    context.close();
  }

  @Test
  public void testGetBeansFromIoc() {
    String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
    Arrays.stream(beanDefinitionNames).forEach(System.out::println);

  }
}
