package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;
import cn.edu.ntu.javase.common.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class IntegrateWithCollectionTest {

    @Test
    public void testGenericInherit() {
        List<Person> pers =
                new ArrayList<Person>() {
                    {
                        add(new Person("zack", 15));
                        add(new Person("tim", 18));
                        add(new Person("kayla", 20));
                    }
                };

        List<Student> stus =
                new ArrayList<Student>() {
                    {
                        add(new Student("zack", 15));
                        add(new Student("tim", 18));
                        add(new Student("kayla", 20));
                    }
                };

        IntegrateWithCollection.countAge(stus);
        IntegrateWithCollection.countAge1(pers);
        // IntegrateWithCollection.countAge1(stus); // compile error
    }
}
