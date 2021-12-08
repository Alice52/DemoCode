package cn.edu.ntu.javase.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static cn.edu.ntu.javase.java8.stream.StreamTest.EMPLOYEES;

/**
 * @author asd <br>
 * @create 2021-12-08 10:35 AM <br>
 * @project javase <br>
 */
@Slf4j
public class MatchTests {

    @Test
    public void testMatch() {
        boolean anyMatch = EMPLOYEES.stream().anyMatch(x -> x.getAge() > 4);
        assert anyMatch : "exist element gt 4";

        boolean matched = EMPLOYEES.stream().allMatch(i -> i.getAge() < 6);
        assert !matched : "not all element lt 6";

        boolean noneMatch = EMPLOYEES.stream().noneMatch(i -> i.getAge() < 1);
        assert noneMatch : "no element lt 1";
    }
}
