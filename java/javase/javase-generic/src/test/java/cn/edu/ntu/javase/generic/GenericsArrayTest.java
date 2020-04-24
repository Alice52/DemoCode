package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-04-22 14:13 <br>
 */
public class GenericsArrayTest {
  private static final Logger LOG = LoggerFactory.getLogger(GenericsArrayTest.class);

  @Test
  public void testArray() {

    Person[] persons = new GenericsArray().getArray(Person.class, 10);

    // [null, null, null, null, null, null, null, null, null, null]
    LOG.info(Arrays.toString(persons));
    for (int i = 0; i < persons.length; i++) {
      persons[i] = new Person(String.valueOf(i), i);
    }
    // [Person{name='0', age=0}, Person{name='1', age=1}, Person{name='2', age=2},
    // Person{name='3', age=3}, Person{name='4', age=4}, Person{name='5', age=5},
    // Person{name='6', age=6}, Person{name='7', age=7}, Person{name='8', age=8},
    // Person{name='9', age=9}]
    LOG.info(Arrays.toString(persons));
  }

  @Test
  public void testList() throws InstantiationException, IllegalAccessException {

    List<Person> list = GenericsArray.getList(Person.class);
    LOG.info(list.size() + "");
  }

  @Test
  public void test() {
    List<Person> list = new ArrayList<>();
    // class java.util.ArrayList
    LOG.info(list.getClass() + "");
  }
}
