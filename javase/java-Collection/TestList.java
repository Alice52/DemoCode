import java.util.*;

import org.junit.Test;


/**
 * 功能：
 * 1. 这里只写了一个不定个数参数的测试
 * 2. Arrays.asList(Object …args); //返回一个只读形的List,不是ArrayList也不是Vector
 */
public class TestList {

    public void testArguments_length(String... args) {
        System.out.println(args.length);
    }

    /**
     * 功能：对List列表中的数据按年龄生序排序
     */
    @Test
    public void ListSort() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张壮壮", 20));
        persons.add(new Person("连顺", 15));
        persons.add(new Person("王凡", 60));
        persons.add(new Person("李壮", 28));
        persons.add(new Person("王壮", 12));
        persons.add(new Person("孙壮", 42));
        persons.forEach(person -> System.out.println(person));

        Collections.sort(persons, Comparator.comparing(Person::getName));
        persons.forEach(person -> System.out.println(person));
    }

    /**
     * 功能：这里主要是想说明
     * 1. // ERROR:List<Object> objList 不是 List<String> strList的父类
     * List<Object> objList = strList; //ERROR:
     * // 这里是面向过程编程，不是面向对象编程
     * 2. public  static void printPersonZInfo2(List<? extends PersonZ>PersonZs) {
     * for(PersonZ PersonZ:PersonZs){
     * System.out.println(PersonZ);
     * }
     * }
     * // 这里要是转换成面向对象：就等价于子类重写父类的方法，并且可以通过父类.方法名来调用
     */
    @Test
    public void testGeneralAndList() {
        List<String> strList = Arrays.asList("AA", "BB");
        System.out.println(strList);
        // List<Object> objList = strList; // compile error: List<Object> objList 不是List<String> strList 的父类

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("zack", 20));
        persons.add(new Person("alice", 22));
        persons.add(new Person("klein", 40));
        printPersonInfo(persons);

        // test List<Student>
        List<Student> students = new ArrayList<>();
        students.add(new Student(20, "zack", "hi"));
        students.add(new Student(22, "lug", "hi"));
        students.add(new Student(40, "1465", "hi"));
        // printPersonInfo(students);  // compile error
        printStudentInfo(students);
    }

    public static void printPersonInfo(List<Person> persons) {
        persons.forEach(person -> System.out.println(person));
    }

    public static void printStudentInfo(List<? extends Person> students) {
        students.forEach(student -> System.out.println(student));
    }
}