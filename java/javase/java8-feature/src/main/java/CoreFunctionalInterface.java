import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zack
 * @create 2019-05-29 16:53
 * @function 测试 java 内置的四大核心函数式接口
 *    1. Consumer<T>: void accept(T t)
 *    2. Supplier<T>: T get()
 *    3. Function<T, R>: R apply(T t)
 *    4. Predicate<T>: bool test(T t)
 */
public class CoreFunctionalInterface {
  /**
   * Consumer<T>: void accept(T t)
   *
   * @function:
   */
  public void consume(double money, Consumer<Double> consumer) {
    consumer.accept(money);
  }

  @Test
  public void testConsumer() {
    consume(1000, (money) -> System.out.println("练顺去洗脚, 消费 " + money + " 元."));
  }

  /**
   * Supplier<T>: T get()
   *
   * @function: 在 num 范围内产生一些数, 并放入集合中
   */
  public Set<Integer> generateData(Integer num, Supplier<Integer> supplier) {
    Set set = new HashSet();
    for (int i = 0; i < num; i++) {
      Integer n = supplier.get(); // 接口中的方法实现
      set.add(n);
    }
    return set;
  }

  @Test
  public void testSupplier() {
    Set set = generateData(50, () -> (int) (Math.random() * 100));
    System.out.println(set);
  }

  @Test
  public void testSupplier2() {
    Set set = new HashSet();
    int size = 50;
    Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
    for (int i = 0; i < size; i++) {
      Integer n = supplier.get();
      set.add(n);
    }
    System.out.println(set.size());
  }

  /**
   * Function<T, R>: R apply(T t)
   * @function: h获取字符长度
   */
  public Integer strHandler(String str, Function<String, Integer> func) {
    Integer size = func.apply(str);
    return size;
  }

  @Test
  public void testFunctionNoLambda() {
    Integer size =
        strHandler(
            "And this file just interprets the directory information at that level.",
            new Function<String, Integer>() {
              @Override
              public Integer apply(String s) {
                return s.length();
              }
            });
    System.out.println(size);
  }

  @Test
  public void testFunction() {
    Integer size =
        strHandler(
            "And this file just interprets the directory information at that level.",
            (str) -> str.length());
    System.out.println(size);
  }

  @Test
  public void testFunction2() {
    Function<String, Integer> func = (str) -> str.length();
    int size = func.apply("And this file just interprets the directory information at that level.");
    System.out.println(size);
  }

  /**
   * Predicate<T>: bool test(T t): 断言型接口
   * @function: 将满足条件的字符串, 过滤满足条件的字符串.
   */
  public List<String> filterStrings(List<String> strs, Predicate<String> predicate) {
    List<String> sts = new ArrayList<>();
    for (String str : strs) {
      if (predicate.test(str)) sts.add(str);
    }
    return sts;
  }

  @Test
  public void testAddListNoLambda() {
    List<String> strings = Arrays.asList("hello", "zack", "logo", "fans");
    List<String> strs =
        filterStrings(
            strings,
            new Predicate<String>() {
              @Override
              public boolean test(String s) {
                return s.contains("a");
              }
            });
    strs.forEach(System.out::println);
  }

  @Test
  public void testAddList() {
    List<String> strings = Arrays.asList("hello", "zack", "logo", "fans");
    List<String> strs = filterStrings(strings, (str) -> str.contains("a"));
    strs.forEach(System.out::println);
  }
}
