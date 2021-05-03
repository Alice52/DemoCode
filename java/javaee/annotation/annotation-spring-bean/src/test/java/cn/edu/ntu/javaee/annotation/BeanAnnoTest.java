package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.bean.BeanAnno;
import cn.edu.ntu.javaee.annotation.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zack <br>
 * @create 2020-04-29 20:39 <br>
 */
@Slf4j
public class BeanAnnoTest {
    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(BeanAnno.class);

    @Test
    public void testIocContainer() {

        Person person = (Person) applicationContext.getBean("person");
        log.info(String.valueOf(person));

        Person alice52 = (Person) applicationContext.getBean("alice52");
        log.info(String.valueOf(alice52));
    }

    @Test
    @Ignore
    /**
     * This will throw {@link org.springframework.beans.factory.NoUniqueBeanDefinitionException}
     * exception due to IOC container has two beans. <br>
     */
    public void testIoc() {

        Person person = applicationContext.getBean(Person.class);
        log.info(String.valueOf(person));
    }
}
