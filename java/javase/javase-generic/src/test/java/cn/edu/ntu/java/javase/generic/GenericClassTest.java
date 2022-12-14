package cn.edu.ntu.java.javase.generic;

import cn.edu.ntu.java.javase.common.model.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 22:54 <br>
 */
public class GenericClassTest {
    private static final Logger LOG = LoggerFactory.getLogger(GenericClassTest.class);

    @Test
    public void testCreateInstance() {
        GenericClass<Person> baseGeneric = new GenericClass<>();
        Person person = baseGeneric.createInstance(Person.class);
        LOG.info("person: {}", person);
    }

    @Test
    public void testCreateInstance2() {
        GenericClass<Person> baseGeneric = new GenericClass<>();
        Person person = baseGeneric.createInstance2();
        LOG.info("person: {}", person);
    }
}
