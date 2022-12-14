package cn.edu.ntu.java.javase.collection.list;

import cn.edu.ntu.java.javase.common.model.Person;

import java.util.Arrays;
import java.util.List;

import static cn.edu.ntu.java.javase.collection.ObjectFactory.persons;
import static cn.edu.ntu.java.javase.collection.ObjectFactory.students;

/** @author zack */
public class ListWithGeneric {

    @Deprecated
    public static void printPersonInfo(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    public static void printStudentInfo(List<? extends Person> students) {
        students.forEach(System.out::println);
    }

    /**
     * List & Generic
     *
     * <pre>
     *    1. List<Object> objList 不是 List<String> strList 的父类
     *      - 泛型擦除引起的: 字节码中都是 Object
     *    2. 可以使用 <? extends Person>
     * </pre>
     */
    public void testGeneralAndList() {
        List<String> strList = Arrays.asList("AA", "BB");
        // List<Object> objList = strList; // compile error

        printPersonInfo(persons);
        // printPersonInfo(students);  // compile error
        printStudentInfo(students);
    }

    public void testArgumentsLength(String... args) {
        System.out.println(args.length);
    }
}
