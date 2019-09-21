import org.junit.Test;

import java.util.Optional;

/**
 * @author zack
 * @create 2019-10-04 14:10
 * @function test optional API.
 */
public class OptionalAPI {

    @Test
    public void testOptional() {
        Employee employee = new Employee("zack", 12, 30000);
        boolean presentEmployee = Optional.ofNullable(employee).isPresent();
        boolean presentAddress = Optional.ofNullable(employee.getAddress()).isPresent();
        System.out.println("employee is present: "+ presentEmployee);
        System.out.println("Address is present: "+ presentAddress);
    }
}
