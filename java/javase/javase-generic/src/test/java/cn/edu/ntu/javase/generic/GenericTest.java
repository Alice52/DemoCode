package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 22:54 <br>
 */
public class GenericTest {
  private static final Logger LOG = LoggerFactory.getLogger(GenericTest.class);

  @Test
  public void testGeneric() {
    Generic<Person> per = new Generic<>();
    Person person = per.get();
    person.setAge(20);
    System.out.println(person.getAge());

    // public <E> E getProperty(E e)
    int age1 = per.test(12);
    Person s = per.test(new Person("zack", 18));
    LOG.info(age1 + "   " + s);
  }
}
