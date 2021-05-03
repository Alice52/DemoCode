package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.configuration.HelloConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-29 16:36 <br>
 */
@Slf4j
public class AnnotationTest {
    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(HelloConfig.class);

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
    public void testIocObjects() {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();

        Arrays.stream(definitionNames).forEach(System.out::println);
    }
}
