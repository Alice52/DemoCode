package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-04 22:54 <br>
 */
public class GenericMethodImplTest {
    private static final Logger LOG = LoggerFactory.getLogger(GenericMethodImplTest.class);

    private GenericMethodImpl genericMethod = new GenericMethodImpl();

    @Test
    public void testCreateInstance() {
        Person person = genericMethod.produce();
        person.setAge(20);
        LOG.info("person: {}", person);
    }

    @Test
    public void testInterface() {
        int hash = genericMethod.hash();
        LOG.info("hash: {}", hash);
    }

    @Test
    public void testMethod() {
        Integer max = GenericMethodImpl.max(Arrays.asList(1, 2, 5, 4));
        LOG.info("max: {}", max);
    }
}
