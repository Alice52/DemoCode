package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.impor.ImportAnno;
import cn.edu.ntu.javaee.annotation.impor.factory.DogFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-29 21:30 <br>
 */
@Slf4j
public class ImportAnnoTest {
    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ImportAnno.class);

    @Test
    public void testGetObjectFromIocFactoryBean() {

        Object bean = applicationContext.getBean("dogFactoryBean");
        // class cn.edu.ntu.javaee.annotation.common.model.Dog
        log.info(String.valueOf(bean.getClass()));

        // Used to dereference a FactoryBean instance and distinguish it from beans created by the
        // FactoryBean.
        // For example, if the bean named dogFactoryBean is a FactoryBean, <br>
        // getting &dogFactoryBean will return the factory, <br>
        // not the instance returned by the factory. <br>
        Object bean2 = applicationContext.getBean("&dogFactoryBean");
        // class cn.edu.ntu.javaee.annotation.impor.factory.DogFactoryBean
        log.info(String.valueOf(bean2.getClass()));

        Object bean3 = applicationContext.getBean(DogFactoryBean.class);
        // class cn.edu.ntu.javaee.annotation.impor.factory.DogFactoryBean
        log.info(String.valueOf(bean3.getClass()));
    }

    @Test
    public void testGetObjectsFromIoc() {

        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionNames).forEach(System.out::println);
    }

    @Test
    public void testGetPersonFromIoc() {

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(beanNamesForType)
                .forEach(
                        x -> {
                            log.info(String.valueOf(applicationContext.getBean(x)));
                        });
    }
}
