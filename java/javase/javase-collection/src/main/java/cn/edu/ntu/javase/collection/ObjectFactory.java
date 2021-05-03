package cn.edu.ntu.javase.collection;

import cn.edu.ntu.javase.common.model.Person;
import cn.edu.ntu.javase.common.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-02-27 17:44 <br>
 * @project javase <br>
 */
public final class ObjectFactory {
    public static List<Person> persons =
            new ArrayList<Person>() {
                {
                    add(new Person("A", 20));
                    add(new Person("B", 15));
                    add(new Person("C", 60));
                    add(new Person("D", 28));
                    add(new Person("E", 12));
                    add(new Person("F", 42));
                }
            };

    public static List<Student> students =
            new ArrayList<Student>() {
                {
                    add(new Student(20, "zack", "hi"));
                    add(new Student(22, "lug", "hi"));
                    add(new Student(40, "1465", "hi"));
                }
            };
}
