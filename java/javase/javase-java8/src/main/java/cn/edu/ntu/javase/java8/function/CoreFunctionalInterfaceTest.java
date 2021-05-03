package cn.edu.ntu.javase.java8.function;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.Math.random;

/**
 * * 测试 java 内置的四大核心函数式接口 <br>
 * 1. Consumer<T>: void accept(T t) <br>
 * 2. Supplier<T>: T get() <br>
 * 3. Function<T, R>: R apply(T t) <br>
 * 4. Predicate<T>: bool test(T t) <br>
 *
 * @author zack <br>
 * @create 2020-04-04 19:02 <br>
 */
public class CoreFunctionalInterfaceTest {

    private static final Logger LOG = LoggerFactory.getLogger(CoreFunctionalInterfaceTest.class);

    /** Consumer<T>: void accept(T t) */
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
     * @return 在 num 范围内产生一些数, 并放入集合中
     */
    public Set<Integer> generateData(Integer num, Supplier<Integer> supplier) {
        Set set = new HashSet();
        for (int i = 0; i < num; i++) {
            // 接口中的方法实现
            Integer n = supplier.get();
            set.add(n);
        }
        return set;
    }

    @Test
    public void testSupplier() {
        Set set = generateData(50, () -> (int) (random() * 100));
        set.parallelStream().forEach(System.out::println);
    }

    @Test
    public void testSupplier2() {
        Set set = new HashSet();
        int size = 50;
        Supplier<Integer> supplier = () -> (int) (random() * 100);
        Stream<Integer> stream = Stream.generate(supplier).limit(size);
        stream.forEach(x -> set.add(x));
        LOG.info(set.size() + "");
    }

    /**
     * Function<T, R>: R apply(T t)
     *
     * @function: h 获取字符长度
     */
    public Integer strHandler(String str, Function<String, Integer> func) {
        return func.apply(str);
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
    public void testFunctionReference() {
        Integer size =
                strHandler(
                        "And this file just interprets the directory information at that level.",
                        String::length);
        System.out.println(size);
    }

    @Test
    public void testFunction2() {
        Function<String, Integer> func = (str) -> str.length();
        int size =
                func.apply(
                        "And this file just interprets the directory information at that level.");
        LOG.info(size + "");
    }

    /**
     * Predicate<T>: bool test(T t): 断言型接口
     *
     * @function: 将满足条件的字符串, 过滤满足条件的字符串.
     */
    private List<String> filterStrings(List<String> strs, Predicate<String> predicate) {
        List<String> sts = new ArrayList<>();
        strs.stream().filter(predicate).forEach(x -> sts.add(x));
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
