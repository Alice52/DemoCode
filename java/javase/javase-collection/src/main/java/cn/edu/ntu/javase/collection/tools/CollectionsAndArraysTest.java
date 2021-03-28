package cn.edu.ntu.javase.collection.tools;

import cn.edu.ntu.javase.common.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static cn.edu.ntu.javase.collection.ObjectFactory.persons;

/**
 * @author zack <br>
 * @create 2021-02-27 17:42 <br>
 * @project javase <br>
 */
public class CollectionsAndArraysTest {

  public static void main(String[] args) {}
  /** 对List列表中的数据按年龄生序排序 */
  @Test
  public void ListSort() {
    Arrays.sort(new int[] {});
    Collections.sort(persons, Comparator.comparing(Person::getAge));
    persons.forEach(System.out::println);
  }

  /**
   * 取集合 Collection 中最小值[按需求找<br>
   *
   * <pre>
   *    1. Object min(Collection)             // 自然排序-对象要实现 Comparable 接口
   *    2. Object min(Collection, Comparator) // 定制排序, 传入比较器
   * </pre>
   */
  @Test
  public void testMin() {
    Person sortByAge = Collections.min(persons, Comparator.comparingInt(Person::getAge));
    Person sortByName = Collections.min(persons, Comparator.comparing(Person::getName));
  }
}
