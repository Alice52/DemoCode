package cn.edu.ntu.java.javase.java8.stream;

import cn.edu.ntu.java.javase.common.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author asd <br>
 * @create 2021-12-08 10:36 AM <br>
 * @project javase <br>
 */
@Slf4j
public class CollectTests {
    @Test
    public void testCollect() {

        List<String> collect = StreamTest.EMPLOYEES.stream().map(Employee::getName).collect(toList());
        collect.forEach(System.out::println);

        HashSet<String> collect1 =
                StreamTest.EMPLOYEES.stream()
                        .map(Employee::getName)
                        .collect(Collectors.toCollection(() -> new HashSet<>()));
        HashSet<String> collect2 =
                StreamTest.EMPLOYEES.stream()
                        .map(Employee::getName)
                        .collect(Collectors.toCollection(HashSet::new));
        collect2.forEach(System.out::println);

        Map<String, List<Employee>> collect3 =
                StreamTest.EMPLOYEES.stream()
                        .collect(
                                Collectors.groupingBy(
                                        (Employee e) -> {
                                            if (e.getSalary() > 4500) {
                                                return "HIGH";
                                            } else {
                                                return "LOWER";
                                            }
                                        }));
        log.info(collect3.toString());

        Map<String, Map<String, List<Employee>>> collect4 =
                StreamTest.EMPLOYEES.stream()
                        .collect(
                                Collectors.groupingBy(
                                        (Employee e) -> {
                                            if (e.getSalary() > 4500) {
                                                return "HIGH";
                                            } else {
                                                return "LOWER";
                                            }
                                        },
                                        Collectors.groupingBy(
                                                (Employee e) -> {
                                                    if (e.getAge() > 30) {
                                                        return "OLDER";
                                                    } else {
                                                        return "YOUNGER";
                                                    }
                                                })));
        log.info(collect4.toString());
    }
}
