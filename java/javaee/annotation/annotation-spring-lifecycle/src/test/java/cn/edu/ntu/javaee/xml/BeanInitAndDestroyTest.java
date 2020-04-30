package cn.edu.ntu.javaee.xml;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zack <br>
 * @create 2020-04-30 11:57 <br>
 */
@Slf4j
public class BeanInitAndDestroyTest {

  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

  @Test
  public void testBeanInitAndDestroy() {
    Person person = applicationContext.getBean(Person.class);
    log.info(String.valueOf(person));

    ClassPathXmlApplicationContext context =
        (ClassPathXmlApplicationContext) this.applicationContext;
    context.close();
  }
}
