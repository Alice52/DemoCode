package cn.edu.ntu.java.javase.java8.stream;

import cn.edu.ntu.java.javase.common.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author asd <br>
 * @create 2021-12-08 10:34 AM <br>
 * @project javase <br>
 */
@Slf4j
public class MapReduceTests {

    @Test
    public void testMap() {
        Stream<Employee> stream = StreamTest.EMPLOYEES.stream();
        stream.map(Employee::getName).forEach(System.out::println);

        List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd");
        Stream<Stream<Character>> streamStream =
                list.stream()
                        .map(
                                str -> {
                                    List<Character> list2 = new ArrayList<>();
                                    for (char c : str.toCharArray()) {
                                        list2.add(c);
                                    }
                                    return list2.stream();
                                });
        Stream<Stream<Character>> streamStream2 = list.stream().map(StreamTest::filterCharacter);
        streamStream2.forEach(sm -> sm.forEach(System.out::println));
    }

    @Test
    public void testMap2() {
        int a = 3;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(
                        arr ->
                                System.out.println(
                                        "a: " + arr[0] + ", b: " + arr[1] + " c:" + arr[2]));
    }

    @Test
    public void testFlatMap() {
        List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd");
        Stream<Character> characterStream = list.stream().flatMap(StreamTest::filterCharacter);
        characterStream.forEach(System.out::println);
    }

    @Test
    public void testStreamFlatMap() {
        String[] words = {"Hello", "world", "hello world"};

        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(" "));
        stream.forEach(x -> Arrays.asList(x).forEach(System.out::println));

        Stream<String[]> stream2 = Arrays.stream(words).map(w -> w.split(" "));
        Stream<String> stringStream = stream2.flatMap(Arrays::stream);
        stringStream.forEach(System.out::println);

        Stream<String[]> stream3 = Arrays.stream(words).map(w -> w.split(" "));
        Stream<String> strStream = stream3.flatMap(t -> Stream.of(t));
        strStream.forEach(System.out::println);
    }

    @Test
    public void testMapV2() {

        List<Employee> employees =
                Arrays.asList(
                        new Employee(null, 18, 6500),
                        new Employee(null, 8, 3000),
                        new Employee(null, 38, 6000),
                        new Employee(null, 58, 8000));

        Map<Integer, String> collect =
                employees.stream()
                        .collect(
                                HashMap::new,
                                (m, v) -> m.put(v.getAge(), v.getName()),
                                HashMap::putAll);

        log.info("map: {}", collect);
    }

    /*
     * =============================================
     * reduce
     * =============================================
     */

    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        log.info("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        log.info("list求积：" + product.get());
        log.info("list求和：" + max.get() + "," + max2);
    }

    @Test
    public void testReduceV2() {
        Double reduce1 =
                StreamTest.EMPLOYEES.stream().map(Employee::getSalary).reduce(0.0, (x, y) -> x + y);
        log.info(reduce1.toString());

        List<Employee> list = new ArrayList<>();
        Optional<Double> reduce = list.stream().map(Employee::getSalary).reduce(Double::sum);
        reduce.ifPresent(System.out::println);
    }
}
