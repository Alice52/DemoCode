package cn.edu.ntu.java.javase.java8.stream;

import cn.edu.ntu.java.javase.common.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://mp.weixin.qq.com/s?__biz=MzIyODE5NjUwNQ==&mid=2653342095&idx=1&sn=64e4e815e65ee64a5c893418f0e2359a
 *
 * @author zack <br>
 * @create 2020-04-04 20:08 <br>
 */
@Slf4j
public class StreamTest {

    public static final List<Employee> EMPLOYEES =
            Arrays.asList(
                    new Employee("张壮", 18, 6500),
                    new Employee("练顺", 8, 3000),
                    new Employee("王凡", 38, 6000),
                    new Employee("张程", 58, 8000));

    public static Stream<Character> filterCharacter(String string) {
        List<Character> list = new ArrayList<>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void testSkip() {
        Stream<Employee> stream = EMPLOYEES.stream();
        stream.filter(e -> e.getAge() > 30).skip(2).forEach(System.out::println);
    }

    @Test
    public void testSort() {
        List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd");
        list.stream().sorted().forEach(System.out::println);
        EMPLOYEES.stream()
                .sorted(Comparator.comparingInt(x -> (int) (-x.getAge())))
                .forEach(System.out::println);
    }

    //  private List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void testFind() {
        Optional<Employee> employee = EMPLOYEES.stream().filter(i -> i.getAge() == 2).findAny();
        EMPLOYEES.stream().filter(i -> i.getAge() == 18).findFirst().ifPresent(System.out::println);
    }

    @Test
    public void testSplit() {
        int splitSize = 3;
        StreamUtil.split(EMPLOYEES, splitSize).forEach(System.out::println);
    }
}
