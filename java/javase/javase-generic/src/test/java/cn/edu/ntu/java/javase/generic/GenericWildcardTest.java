package cn.edu.ntu.java.javase.generic;

import cn.edu.ntu.java.javase.common.model.Person;
import cn.edu.ntu.java.javase.common.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class GenericWildcardTest {

    @Test
    public void testMerge() {
        List<Person> dest =
                new ArrayList<Person>() {
                    {
                        add(new Person("zack", 15));
                        add(new Person("tim", 18));
                        add(new Person("kayla", 20));
                    }
                };

        List<Student> src =
                new ArrayList<Student>() {
                    {
                        add(new Student("zack-s", 15));
                        add(new Student("tim-s", 18));
                        add(new Student("kayla-s", 20));
                    }
                };

        GenericWildcard.merge(dest, src);
        dest.forEach(System.out::println);

        GenericWildcard.mergeSameType(dest, Arrays.asList(new Person("kayla-s", 20)));
        dest.forEach(System.out::println);

        GenericWildcard<Person> wildcard = new GenericWildcard<>();
        wildcard.mergeSameType2(dest, Arrays.asList(new Person("kayla-s", 20)));
        dest.forEach(System.out::println);
    }
}
