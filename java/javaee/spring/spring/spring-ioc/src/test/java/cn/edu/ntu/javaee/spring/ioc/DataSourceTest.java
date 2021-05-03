package cn.edu.ntu.javaee.spring.ioc;

import cn.edu.ntu.javaee.spring.common.constants.Constants;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zack
 * @create 2019-10-27 21:43
 * @function
 */
public class DataSourceTest {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceTest.class);
    private ApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_XML_PATH);
    }

    @Test
    public void testConnection() {
        ComboPooledDataSource comboPooledDataSource =
                ctx.getBean("dataSource", ComboPooledDataSource.class);
        LOG.info(
                "get dataSource connection bean: {} from IOC container success.",
                comboPooledDataSource);
    }
}
