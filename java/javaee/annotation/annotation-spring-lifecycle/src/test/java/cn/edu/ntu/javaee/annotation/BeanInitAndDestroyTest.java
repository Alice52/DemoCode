package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.bean.BeanInitAndDestroy;
import cn.edu.ntu.javaee.annotation.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zack <br>
 * @create 2020-04-30 11:51 <br>
 */
@Slf4j
public class BeanInitAndDestroyTest {

    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(BeanInitAndDestroy.class);

    @Test
    public void testBeanInitAndDestroy() {
        Person person = applicationContext.getBean(Person.class);
        log.info(String.valueOf(person));

        AnnotationConfigApplicationContext context =
                (AnnotationConfigApplicationContext) this.applicationContext;
        context.close();
    }
}
