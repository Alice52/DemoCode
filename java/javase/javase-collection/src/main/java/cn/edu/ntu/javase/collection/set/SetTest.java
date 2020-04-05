package cn.edu.ntu.javase.collection.set;

import cn.edu.ntu.javase.common.model.Person;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author zack <br>
 * @create 2020-04-04 22:39 <br>
 */
@Slf4j
public class SetTest {

  @Test
  public void TestHashSet() {

    Set<Person> PEOPLE = new HashSet<>();

    PEOPLE.add(new Person("AA", 10));
    PEOPLE.add(new Person("BB", 11));
    PEOPLE.add(new Person("CC", 12));
    PEOPLE.add(new Person("DD", 13));
    PEOPLE.add(new Person("EE", 14));
    PEOPLE.add(new Person("EE", 15));

    Assert.isTrue(6 == PEOPLE.size());
    PEOPLE.forEach(System.out::println);
  }

  @Test
  public void TestLinkedHashSet() {

    Set<Person> PEOPLE = new LinkedHashSet<>();

    PEOPLE.add(new Person("AA", 10));
    PEOPLE.add(new Person("BB", 11));
    PEOPLE.add(new Person("EE", 14));
    PEOPLE.add(new Person("CC", 12));
    PEOPLE.add(new Person("DD", 13));
    PEOPLE.add(new Person("DD", 13));
    Assert.isTrue(6 == PEOPLE.size());

    PEOPLE.forEach(System.out::println);
  }

  /**
   * 方法一: 这里 Person 类实现 Comparable 接口中的 CompareTo 方法<br>
   * 方法二: 自定义 Comparator
   */
  @Test
  public void testTreeSet2() {

    Set<Person> PEOPLE = new TreeSet<>(Comparator.comparing(Person::getName));

    PEOPLE.add(new Person("AA", 10));
    PEOPLE.add(new Person("DD", 13));
    PEOPLE.add(new Person("EE", 14));
    PEOPLE.add(new Person("BB", 11));
    PEOPLE.add(new Person("CC", 12));
    PEOPLE.add(new Person("CC", 15));

    Assert.isTrue(5 == PEOPLE.size());
    PEOPLE.forEach(System.out::println);
  }
}
