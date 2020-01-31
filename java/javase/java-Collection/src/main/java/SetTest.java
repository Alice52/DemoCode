import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author zack
 */
public class SetTest {

    @Test
    public void TestHashSet() {
        Set<Person> persons = new HashSet<>();

        persons.add(new Person("AA", 10));
        persons.add(new Person("BB", 11));
        persons.add(new Person("CC", 12));
        persons.add(new Person("DD", 13));
        persons.add(new Person("EE", 14));
        persons.add(new Person("EE", 15));
        // 6
        System.out.println(persons.size());

        persons.forEach(person -> System.out.println(person));
    }

    @Test
    public void TestLinkedHashSet() {
        Set<Person> persons = new LinkedHashSet<>();

        persons.add(new Person("AA", 10));
        persons.add(new Person("BB", 11));
        persons.add(new Person("EE", 14));
        persons.add(new Person("CC", 12));
        persons.add(new Person("DD", 13));
        persons.add(new Person("DD", 13));
        // 6
        System.out.println(persons.size());

        persons.forEach(person -> System.out.println(person));
    }


    /**
     *  方法一: 这里 Person 类实现 Comparable 接口中的 CompareTo 方法<br>
     *  方法二: 自定义 Comparator
     */
    @Test
    public void testTreeSet2() {

        Set<Person> persons = new TreeSet<>(Comparator.comparing(Person::getName));

        persons.add(new Person("AA", 10));
        persons.add(new Person("DD", 13));
        persons.add(new Person("EE", 14));
        persons.add(new Person("BB", 11));
        persons.add(new Person("CC", 12));
        persons.add(new Person("CC", 15));
        //5
        System.out.println(persons.size());

        persons.forEach(person -> System.out.println(person));
    }
}

