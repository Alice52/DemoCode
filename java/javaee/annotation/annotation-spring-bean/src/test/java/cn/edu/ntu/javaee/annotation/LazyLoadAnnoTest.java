package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.scope.LazyLoadAnno;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zack <br/>
 * @create 2020-04-29 19:22 <br/>
 */
@Slf4j
public class LazyLoadAnnoTest {
    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(LazyLoadAnno.class);

    @Test
    public void testIocContainer() {

        Person person = applicationContext.getBean(Person.class);
        log.info(String.valueOf(person));
    }
}
