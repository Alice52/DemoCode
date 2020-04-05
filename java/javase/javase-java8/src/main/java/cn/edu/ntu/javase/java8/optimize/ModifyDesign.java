package cn.edu.ntu.javase.java8.optimize;

import cn.edu.ntu.javase.common.model.Employee;
import cn.edu.ntu.javase.java8.function.FilterInterface;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 使用 策略设计模式 和 Lambda 优化重复代码<br>
 *
 * @author zack <br>
 * @create 2020-04-04 20:01 <br>
 */
public class ModifyDesign {
  private static final List<Employee> EMPLOYEES =
      Arrays.asList(
          new Employee("张壮", 18, 6500),
          new Employee("练顺", 8, 3000),
          new Employee("王凡", 38, 6000),
          new Employee("张程", 58, 8000));

  /**
   * function: 过滤年纪大于 20 岁的员工
   *
   * @param employees
   * @return List<Employee>
   */
  public List<Employee> filterEmployeeByAge(List<Employee> employees) {
    List<Employee> emps = new ArrayList<>();
    employees.stream().filter(x -> x.getAge() > 20).forEach(x -> emps.add(x));
    return emps;
  }

  /**
   * function: 过滤工资大于 5000 的员工
   *
   * @param employees
   * @return List<Employee>
   */
  public List<Employee> filterEmployeeBySalary(List<Employee> employees) {
    List<Employee> emps = new ArrayList<>();
    Iterator iterator = employees.iterator();
    while (iterator.hasNext()) {
      Employee employee = (Employee) iterator.next();
      if (employee.getSalary() > 5000) {
        emps.add(employee);
      }
    }
    return emps;
  }

  @Test
  public void testFilterEmployee() {
    List<Employee> emps = filterEmployeeByAge(EMPLOYEES);
    List<Employee> emps2 = filterEmployeeBySalary(EMPLOYEES);
    System.out.println(emps2);
  }

  /** 优化1: 使用 设计模式进行优化: 策略设计模式-接口 * */
  public List<Employee> filterEmployee(List<Employee> employees, FilterInterface<Employee> fe) {
    List<Employee> emps = new ArrayList<>();

    for (Employee employee : employees) {
      if (fe.condition(employee)) {
        emps.add(employee);
      }
    }
    return emps;
  }

  /** 过滤工资大于 5000 的员工* */
  @Test
  public void testFilterEmployee3() {

    List<Employee> emps =
        filterEmployee(
            EMPLOYEES,
            new FilterInterface<Employee>() {
              @Override
              public boolean condition(Employee employee) {
                return employee.getSalary() > 5000;
              }
            });
    System.out.println(emps);
    // 过滤年纪大于 30 的员工
    List<Employee> emps2 = filterEmployee(EMPLOYEES, (employee) -> employee.getAge() > 30);
    emps2.forEach(System.out::println);
  }

  /** 优化2: 使用 Stream 进行优化* */
  @Test
  public void testFilterEmployee4() {
    EMPLOYEES.stream().filter((e) -> e.getSalary() > 5000).forEach(System.out::println);
  }
}
