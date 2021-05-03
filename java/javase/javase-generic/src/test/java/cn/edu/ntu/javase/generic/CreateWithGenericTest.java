package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;
import cn.edu.ntu.javase.generic.create.CreateWithGeneric;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
@Slf4j
public class CreateWithGenericTest {
    @Test
    public void testCreateArray() {
        Integer[] array = CreateWithGeneric.createArray(Integer.class, 2);
        array[0] = 1;
        log.info("{}", array);
        Person[] people = CreateWithGeneric.createArray(Person.class, 2);
        log.info("{}", people[0]);

        List<Person> list = Arrays.asList(people);
        log.info("{}", list);
    }

    @Test
    public void testCreateList() {
        List<Integer> list = CreateWithGeneric.createList(Integer.class);
        list.set(0, 1);
        log.info("{}", list);
        List<Person> people = CreateWithGeneric.createList(Person.class);
        log.info("{}", people); // [Person{name='null', age=0}]

        List<Integer> list1 = CreateWithGeneric.createList(Integer.class, 2);
        log.info("{}", list1); // [null, null]
    }

    @Test
    public void testCreateInteger() {
        Integer integer = CreateWithGeneric.CreateBasicType(Integer.class, 1);
        log.info("{}", integer);
    }
}
