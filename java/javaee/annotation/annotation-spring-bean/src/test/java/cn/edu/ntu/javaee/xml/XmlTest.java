package cn.edu.ntu.javaee.xml;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-29 16:42 <br>
 */
@Slf4j
public class XmlTest {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void testIocContainer() {

        Person person = (Person) applicationContext.getBean("person");
        log.info(String.valueOf(person));
    }

    @Test
    /** The bean name is bean id in xml. */
    public void testGetBeanName() {
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);
    }

    @Test
    public void testIocObjects() {

        String[] definitionNames = applicationContext.getBeanDefinitionNames();

        Arrays.stream(definitionNames).forEach(System.out::println);
    }
}
