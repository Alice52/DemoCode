package cn.edu.ntu.spring.demo;

import cn.edu.ntu.spring.constants.Constants;
import cn.edu.ntu.spring.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zack
 * @create 2019-10-27 13:14
 * @function
 */
public class HelloWorld {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_XML_PATH);

    Person person = ctx.getBean("person", Person.class);

    LOG.info("get person: {} instance from IOC success.", person.toString());
  }
}
