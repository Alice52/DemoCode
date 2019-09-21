import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author zack
 * @create 2019-05-29 14:38
 * @function
 */
public class Lambda {
  private List<Employee> employees =
      Arrays.asList(
          new Employee("张壮", 18, 6500),
          new Employee("练顺", 8, 3000),
          new Employee("王凡", 38, 6000),
          new Employee("张程", 58, 8000));

  @Test
  public void testAnonymous() {
    Comparator<Integer> comparator =
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
          }
        };
    TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    treeSet.add(4);
    treeSet.add(1);
    treeSet.add(6);
    System.out.println(treeSet);
  }

  @Test
  public void testLambda() {
    TreeSet<Integer> treeSet = new TreeSet<>((o1, o2) -> Integer.compare(o1, o2));
    treeSet.add(4);
    treeSet.add(1);
    treeSet.add(6);
    System.out.println(treeSet);
  }

  @Test
  public void testGrammar() {
    // 格式一: 无参数无返回值
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("hello lambda");
          }
        };
    runnable.run();
    Runnable runnable1 = () -> System.out.println("hello lambda2");
    runnable1.run();

    // 格式二: 有一个参数无返回值
    // Consumer<String> consumer = (x) -> System.out.println(x);
    Consumer<String> consumer = x -> System.out.println(x);
    consumer.accept("练顺大傻逼！");

    // 格式三: 有两个参数有返回值
    Comparator<Integer> comparator =
        (x, y) -> {
          System.out.println("sa");
          return Integer.compare(x, y);
        };
  }

  @Test
  public void lambdaDemo() {
    // 定制排序 Employee: 年龄-姓名
    Collections.sort(
        employees,
        (employee1, employee2) -> {
          if (employee1.getAge() == employee2.getAge())
            return Double.compare(employee1.getSalary(), employee2.getSalary());
          else return Integer.compare(employee1.getAge(), employee2.getAge());
        });
    employees.forEach(System.out::println);
  }
}
