package com.augmentum.springdata;

import com.augmentum.springdata.repository.PersonRepository;
import com.augmentum.springdata.entities.Person;
import com.augmentum.springdata.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author zack
 * @create 2019-08-10 23:11
 * @function the class is to test instance.
 */
public class TestSpringData {

    private static final String APPLICATION_CONTEXT_PATH= "applicationContext.xml";
    private static final Logger LOG = LoggerFactory.getLogger(TestSpringData.class);
    private ApplicationContext ctx;
    private PersonRepository personRepository = null;
    private PersonService personService;


    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_PATH);
        personRepository = ctx.getBean(PersonRepository.class);
        personService= ctx.getBean(PersonService.class);
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = ctx.getBean(DataSource.class);
        LOG.info("get dataSource success: "+ dataSource);
    }


    @Test
    public void testHelloWorldSpringData() {
        LOG.info("personRepository name: " + personRepository.getClass().getName());
        Person person = personRepository.getByLastName("AA");
        LOG.info("person: " + person);
    }

    @Test
    public void testJpa(){

    }
}
