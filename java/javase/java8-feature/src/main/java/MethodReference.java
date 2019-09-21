import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zack
 * @create 2019-05-30 13:08
 * @function test MethodReference
 */
public class MethodReference {

  @Test
  public void testObjectInstance() {
    // 对象::实例方法
    Consumer<Integer> consumer = x -> System.out.println(x);
    consumer.accept(50);
    // 方法引用: 返回值和形参一致
    Consumer<Integer> consumer1 = System.out::println;
    consumer1.accept(50);
    Employee employee = new Employee();
    Supplier<Integer> supplier = () -> employee.getAge();
    System.out.println(supplier.get());
    // 方法引用: 返回值和形参一致
    Supplier<Integer> supplier1 = employee::getAge;
    System.out.println(supplier1.get());

    // 类::静态方法
    Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    Comparator<Integer> comparator1 = Integer::compareTo;

    // 类::实例方法
    BiPredicate<Integer, Integer> biPredicate = (x, y) -> x.equals(y);
    BiPredicate<Integer, Integer> biPredicate1 = Integer::equals;
  }

  @Test
  public void testConstructor() {
    // ClassName::new
    // 无参数
    Supplier<Employee> supplier = () -> new Employee();
    Supplier<Employee> supplier1 = Employee::new; // 找与形参列表匹配的构造器

    // 有参数
    CreateEmployee<String, Integer, Double, Employee> createEmployee =
        (name, age, salary) -> new Employee(name, age, salary);
    System.out.println(createEmployee.sup("zack", 25, 125.03));

    CreateEmployee<String, Integer, Double, Employee> createEmployee2 = Employee::new;
    System.out.println(createEmployee2.sup("zack", 55, 125.03));
  }

  @Test
  public void testArray() {
    // Type::new
    Function<Integer, String[]> func = (x) -> new String[x];
    String[] strs = func.apply(10);
    System.out.println(strs.length);

    Function<Integer, String[]> func1 = String[]::new;
    String[] strs1 = func.apply(20);
    System.out.println(strs1.length);

    Function<Integer, List<Integer>> func2 =
        (x) -> {
          List<Integer> integers = new ArrayList<>();

          for (int i = 0; i < x; i++) {
            int n = (int) (Math.random() * 100);
            integers.add(n);
          }
          return integers;
        };
    System.out.println(func2.apply(50).size());
  }
}
