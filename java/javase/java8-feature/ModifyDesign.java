import org.junit.Test;

import java.io.OutputStream;
import java.util.*;

/**
 * @author zack
 * @create 2019-05-29 13:24
 * @function 使用 策略设计模式 和 Lambda 优化重复代码
 */
public class ModifyDesign {
    private List<Employee> employees = Arrays.asList(new Employee("张壮", 18, 6500), new Employee("练顺", 8, 3000), new Employee("王凡", 38, 6000), new Employee("张程", 58, 8000));

    /**
     * function: 过滤年纪大于 20 岁的员工
     *
     * @param employees
     *
     * @return List<Employee>
     */
    public List<Employee> filterEmployeeByAge(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getAge() > 20) emps.add(emp);
        }
        return emps;
    }

    /**
     * function: 过滤工资大于 5000 的员工
     *
     * @param employees
     *
     * @return List<Employee>
     */
    public List<Employee> filterEmployeeBySalary(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        Iterator iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee.getSalary() > 5000) emps.add(employee);
        }
        return emps;
    }

    @Test
    public void testFilterEmployee() {
        List<Employee> emps = filterEmployeeByAge(employees);
        List<Employee> emps2 = filterEmployeeBySalary(employees);
        System.out.println(emps2);
    }


    // 优化1: 使用 设计模式进行优化: 策略设计模式-接口
    public List<Employee> filterEmployee(List<Employee> employees, FilterInterface<Employee> fe){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (fe.condition(employee)) emps.add(employee);
        }
        return emps;
    }

    @Test
    public void testFilterEmployee3() {
        // 过滤工资大于 5000 的员工
        List<Employee> emps = filterEmployee(employees, new FilterInterface<Employee>(){
            @Override
            public boolean condition(Employee employee) {
                return employee.getSalary() > 5000;
            }
        });
        System.out.println(emps);
        // 过滤年纪大于 30 的员工
        List<Employee> emps2 = filterEmployee(employees, (employee) -> employee.getAge() > 30);
        emps2.forEach(System.out::println);
    }

    // 优化2: 使用 Stream 进行优化
    @Test
    public void testFilterEmployee4() {
        employees.stream().filter((e)-> e.getSalary() > 5000)
                .forEach(System.out::println);
    }
}
