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
 * @create 2019-10-27 22:09
 * @function
 */
public class AutoWireTest {

    private static final Logger LOG = LoggerFactory.getLogger(AutoWireTest.class);
    private ApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_XML_PATH);
    }

    @Test
    public void TestAutoWire12XML() {
        Person person = ctx.getBean("person", Person.class);
        LOG.info("Get person bean: {} success.", person.toString());
    }

    @Test
    public void TestAutoWire12Annotation() {
        Person person = ctx.getBean("person", Person.class);
        LOG.info("Get person bean: {} success.", person.toString());
    }
}
