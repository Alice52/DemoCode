package cn.edu.ntu.javaee.ioc;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.ioc.IocContainer;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zack <br>
 * @create 2020-04-30 13:36 <br>
 */
@Slf4j
public class IocContainerTest {

    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(IocContainer.class);

    @Test
    public void testGetIocContainer() {
        IocContainer contextBean = applicationContext.getBean(IocContainer.class);
        ApplicationContext applicationContext = contextBean.getApplicationContext();

        Person person0 = applicationContext.getBean(Person.class);
        log.info(String.valueOf(person0));

        Person person = applicationContext.getBean(Person.class);
        log.info(String.valueOf(person));

        Assert.isTrue(person0 == person);
        Assert.isFalse(applicationContext == contextBean);
    }
}
