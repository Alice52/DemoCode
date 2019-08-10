package com.augmentum.jpa;

import com.augmentum.jpa.entities.Person;
import com.augmentum.jpa.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author zack
 * @create 2019-08-10 20:07
 * @function
 */
public class TestSpringIntegration {

    private static final String APPLICATION_CONTEXT_PATH = "applicationContext.xml";
    private static final Logger LOG = LoggerFactory.getLogger(TestSpringIntegration.class);
    private PersonService personService = null;
    private ApplicationContext ctx;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_PATH);
        personService = ctx.getBean(PersonService.class);
    }

    // test dataSource
    @Test
    public void testDataSource(){
        DataSource dataSource = ctx.getBean(DataSource.class);
        LOG.info("get dataSource success: "+ dataSource);
    }

    @Test
    public void testPersonService(){
        Person p1 = new Person();
        p1.setAge(11);
        p1.setLastName("AA");

        Person p2 = new Person();
        p2.setAge(12);
        p2.setLastName("BB");

        LOG.info("personService className: " + personService.getClass().getName());
        personService.savePersons(p1, p2);
    }
}
