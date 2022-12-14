package cn.edu.ntu.java.javase.collection.set;

import cn.edu.ntu.java.javase.common.model.Person;
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

        Set<Person> persons = new HashSet<>();

        persons.add(new Person("AA", 10));
        persons.add(new Person("BB", 11));
        persons.add(new Person("CC", 12));
        persons.add(new Person("DD", 13));
        persons.add(new Person("EE", 14));
        persons.add(new Person("EE", 14));

        Assert.isTrue(5 == persons.size());
        persons.forEach(System.out::println);
    }

    @Test
    public void TestLinkedHashSet() {

        Set<Person> persons = new LinkedHashSet<>();

        persons.add(new Person("AA", 18));
        persons.add(new Person("BB", 11));
        persons.add(new Person("EE", 14));
        persons.add(new Person("CC", 12));
        persons.add(new Person("DD", 13));
        persons.add(new Person("DD", 13));
        Assert.isTrue(5 == persons.size());

        persons.forEach(System.out::println);
    }

    /**
     * TreeSet Usage:
     *
     * <pre>
     *     1. 泛型对象实现 Comparable
     *     2. 创建 TreeSet 时指定 comparator
     *     3. 不能存放 null
     *     4. TreeSet 泛型重写该对象对应得 equals()方法时, 应该保证方法与 compareTo(obj) 方法有一致的结果
     *        - Person::getName 作为 unique 的标准
     * </pre>
     */
    @Test
    public void testTreeSet() {

        Set<Person> people = new TreeSet<>(Comparator.comparing(Person::getName));

        people.add(new Person("AA", 10));
        people.add(new Person("DD", 13));
        people.add(new Person("EE", 14));
        people.add(new Person("BB", 11));
        people.add(new Person("CC", 12));
        people.add(new Person("CC", 15));

        Assert.isTrue(5 == people.size());
        people.forEach(System.out::println);
    }
}
