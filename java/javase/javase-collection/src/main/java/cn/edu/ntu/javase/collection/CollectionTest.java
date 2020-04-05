package cn.edu.ntu.javase.collection;

import cn.edu.ntu.javase.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author zack <br>
 * @create 2020-04-04 22:13 <br>
 */
@Slf4j
public class CollectionTest {

  private static final List<Person> PEOPLE =
      Arrays.asList(
          new Person("d", 20),
          new Person("b", 15),
          new Person("c", 60),
          new Person("a", 28),
          new Person("e", 12),
          new Person("f", 42));

  /**
   * 功能：取集合Collection中最小值(按需求找)<br>
   * 1.这里测试的是List：但是对于所有Collection都适应<br>
   * Object min(Collection) //自然排序：对象要实现Comparable接口<br>
   * Object min(Collection，Comparator) //定制排序，姓名按升序排列<br>
   */
  @Test
  public void testMin() {

    // 1.List中的min(): 定制排序，姓名按升序排列
    Person person = Collections.min(PEOPLE, Comparator.comparingInt(Person::getAge));
    Person person8 = Collections.min(PEOPLE, Comparator.comparing(Person::getName));
    log.info(person.toString());
    log.info(person8.toString());
  }

  /** 功能：将 Person 类型的集合转换为 Person 的数组 */
  @Test
  public void testToArray() {

    Person[] people = PEOPLE.toArray(new Person[] {});
    log.info(people.length + "");
  }

  @Test
  public void testCollectionRetainAll() {
    Collection a = new ArrayList(Arrays.asList("a", "b", "c", "d"));
    Collection b = new ArrayList(Arrays.asList("ab", "bc", "e", "f"));
    b.add("g");
    // a will become intersection
    a.retainAll(b);

    a.stream().forEach(System.out::println);
    b.stream().forEach(System.out::println);

    if (a.size() > 0) {
      log.info("have intersection");
    } else {
      log.info("have no intersection");
    }
  }

  @Test
  public void testCollectionAddAll() {
    Collection a = new ArrayList(Arrays.asList("a", "b", "c", "d"));
    Collection b = new ArrayList(Arrays.asList("ab", "bc", "e", "f"));

    b.add("g");
    // a will become union
    a.addAll(b);

    a.stream().forEach(System.out::println);
    b.stream().forEach(System.out::println);
  }
}
