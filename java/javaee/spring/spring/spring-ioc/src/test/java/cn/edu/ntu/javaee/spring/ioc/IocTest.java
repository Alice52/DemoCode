package cn.edu.ntu.javaee.spring.ioc;

import cn.edu.ntu.javaee.spring.common.constants.Constants;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zack
 * @create 2019-10-27 15:04
 * @function
 */
public class IocTest {
    private static final Logger LOG = LoggerFactory.getLogger(IocTest.class);
    private ApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_XML_PATH);
    }

    @Test
    public void testFactoryBean() {
        Person person = ctx.getBean("person4FactoryBean", Person.class);
        LOG.info("get person bean: {} from FactoryBean success.", person.toString());
    }
}
