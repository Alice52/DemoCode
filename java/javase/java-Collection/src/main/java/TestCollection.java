import java.util.*;

import org.junit.Test;


public class TestCollection {

    /**
     * 功能：取集合Collection中最小值(按需求找)
     * 1.这里测试的是List：但是对于所有Collection都适应
     * Object min(Collection)               //自然排序：对象要实现Comparable接口
     * Object min(Collection，Comparator)   //定制排序，姓名按升序排列
     */
    @Test
    public void TestMin() {

        // 1.List中的min(): 定制排序，姓名按升序排列
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("d", 20));
        persons.add(new Person("b", 15));
        persons.add(new Person("c", 60));
        persons.add(new Person("a", 28));
        persons.add(new Person("e", 12));
        persons.add(new Person("f", 42));

        Person person = Collections.min(persons, Comparator.comparingInt(Person::getAge));
        Person person8 = Collections.min(persons, Comparator.comparing(Person::getName));

        System.out.println(person);
        System.out.println(person8);
    }

    /**
     * 功能：将 Person 类型的集合转换为 Person 的数组
     */
    @Test
    public void testToArray() {
        Collection<Person> persons = new ArrayList<>();
        persons.add(new Person("d", 20));
        persons.add(new Person("b", 15));
        persons.add(new Person("c", 60));
        persons.add(new Person("a", 28));
        persons.add(new Person("e", 12));
        persons.add(new Person("f", 42));
        //将Person类型的集合转换为Person的数组
        Person[] pers = persons.toArray(new Person[0]);
        System.out.println(pers.length);
    }
}
