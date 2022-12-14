package cn.edu.ntu.java.javase.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author asd <br>
 * @create 2021-12-08 10:35 AM <br>
 * @project javase <br>
 */
@Slf4j
public class MatchTests {

    @Test
    public void testMatch() {
        boolean anyMatch = StreamTest.EMPLOYEES.stream().anyMatch(x -> x.getAge() > 4);
        assert anyMatch : "exist element gt 4";

        boolean matched = StreamTest.EMPLOYEES.stream().allMatch(i -> i.getAge() < 6);
        assert !matched : "not all element lt 6";

        boolean noneMatch = StreamTest.EMPLOYEES.stream().noneMatch(i -> i.getAge() < 1);
        assert noneMatch : "no element lt 1";
    }
}
