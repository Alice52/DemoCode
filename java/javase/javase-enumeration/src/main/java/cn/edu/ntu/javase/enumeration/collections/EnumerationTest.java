package cn.edu.ntu.javase.enumeration.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Enumeration is old version of iterator, now recommend to use iterator.
 *
 * @author zack <br>
 * @create 2020-01-31 14:31 <br>
 */
public class EnumerationTest {
    private static final Logger LOG = LoggerFactory.getLogger(EnumerationTest.class);

    public static void main(String[] args) {
        Collection array = new ArrayList(Arrays.asList("a", "b", "c", "d"));

        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            LOG.info(iterator.next().toString());
        }

        Enumeration enumeration = Collections.enumeration(array);
        while (enumeration.hasMoreElements()) {
            LOG.info(enumeration.nextElement().toString());
        }
    }
}
