package cn.edu.ntu.java.javase.java8.optional;

import cn.edu.ntu.java.javase.common.model.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author zack <br>
 * @create 2020-04-04 20:07 <br>
 */
public class OptionalTest {

    @Test
    public void testCreate() {
        Optional<Integer> empty = Optional.empty();
        Optional<Integer> of = Optional.of(new Integer(1));
        Optional<Integer> integer = Optional.ofNullable(20);
        Optional<Integer> o = Optional.ofNullable(null);
    }

    @Test
    public void testOptional() {
        Employee employee = new Employee("zack", 12, 30000);
        boolean presentEmployee = Optional.ofNullable(employee).isPresent();
        boolean presentAddress = Optional.ofNullable(employee.getAddress()).isPresent();
        System.out.println("employee is present: " + presentEmployee);
        System.out.println("Address is present: " + presentAddress);
    }
}
