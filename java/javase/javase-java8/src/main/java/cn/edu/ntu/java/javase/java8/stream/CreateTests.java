package cn.edu.ntu.java.javase.java8.stream;

import cn.edu.ntu.java.javase.common.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author asd <br>
 * @create 2021-12-08 10:32 AM <br>
 * @project javase <br>
 */
@Slf4j
public class CreateTests {
    @Test
    /** 创建 Stream */
    public void testCreate() {
        // 1. 通过 Collection 系列集合的 stream() 或 parallelStream()
        List<String> stringList = new ArrayList<>();
        Stream<String> stringStream = stringList.stream();
        // 2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(emps);

        // 3. 通过 Stream 类中的静态方法 of() 获取
        Stream<String> stringStream1 = Stream.of("aa", "bb", "cc");
        stringStream1.forEach(System.out::println);

        // 4. 创建无限流
        // 4.1 迭代: seed ---> 开始位置;
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2).limit(50);
        // 4.2 生成
        Stream<Integer> integerStream2 =
                Stream.generate(() -> (int) (Math.random() * 100)).limit(50);
    }
}
