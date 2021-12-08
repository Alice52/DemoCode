package cn.edu.ntu.javase.java8.stream;

import cn.edu.ntu.javase.common.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.stream.Stream;

import static cn.edu.ntu.javase.java8.stream.StreamTest.EMPLOYEES;

/**
 * @author asd <br>
 * @create 2021-12-08 10:33 AM <br>
 * @project javase <br>
 */
@Slf4j
public class FilterTests {

    @Test
    public void testFilter() {
        Stream<Employee> stream = EMPLOYEES.stream();
        // 找到两个满足添加之后的就停止运算
        stream.filter(e -> e.getAge() > 30).limit(2).forEach(System.out::println);
    }
}
