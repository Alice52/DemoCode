import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zack
 * @create 2019-05-30 15:01
 * @function 1. 创建 Stream
 * 2. 中间操作
 * 3. 终止操作
 */
public class StreamAPI {
    private List<Employee> employees = Arrays.asList(new Employee("张壮", 18, 6500), new Employee("练顺", 8, 3000), new Employee("王凡", 38, 6000), new Employee("张程", 58, 8000));

    @Test
    /**
     * 创建 Stream
     */ public void testCreate() {
        // 1. 通过 Collection 系列集合的 stream() 或 parallelStream()
        List<String> stringList = new ArrayList<>();
        Stream<String> stringStream = stringList.stream();

        // 2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(emps);

        // 3. 通过 Stream 类中的静态方法 of() 获取
        Stream<String> stringStream1 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 4.1 迭代: seed ---> 开始位置;
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
        // 4.2 生成
        Stream<Integer> integerStream2 = Stream.generate(() -> (int) (Math.random() * 100));
    }

    @Test
    public void testMiddleOperation() {
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> {
            System.out.println("短路");
            return e.getAge() > 30;
        }).limit(2).forEach(System.out::println); // 找到两个满足添加之后的就停止运算

        System.out.println("--------skip/filter-------------");
        Stream<Employee> stream2 = employees.stream();
        stream2.filter(e -> {
            System.out.println("短路");
            return e.getAge() > 30;
        }).skip(2).forEach(System.out::println);

        System.out.println("---------map------------");
        Stream<Employee> stream3 = employees.stream();
        // stream3.map(e -> e.getName()).forEach(System.out::println);
        stream3.map(Employee::getName).forEach(System.out::println);


        List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd");
        Stream<Stream<Character>> streamStream = list.stream().map((str) -> {
            List<Character> list2 = new ArrayList<>();
            for (char c : str.toCharArray()) {
                list2.add(c);
            }
            return list2.stream();
        });
        Stream<Stream<Character>> streamStream2 = list.stream().map(StreamAPI::filterCharactor); // {{'a', 'a', 'a'}, {'b', 'b', 'b',} ...}
        streamStream2.forEach(sm -> sm.forEach(System.out::println));

        System.out.println("--------flatMap-------------");
        Stream<Character> characterStream = list.stream().flatMap(StreamAPI::filterCharactor); // {'a', 'a', 'a', 'b', 'b', 'b', ...}
        characterStream.forEach(System.out::println);


        System.out.println("--------sort-------------");
        list.stream().sorted().forEach(System.out::println);
        employees.stream().sorted(Comparator.comparingInt(x -> (int) (-x.getAge()))).forEach(System.out::println);

        System.out.println("--------collection-------------");
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
        HashSet<String> collect1 = employees.stream().map(Employee::getName).collect(Collectors.toCollection(() -> new HashSet<>()));
        HashSet<String> collect2 = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        collect2.forEach(System.out::println);
        Map<String, List<Employee>> collect3 = employees.stream().collect(Collectors.groupingBy((Employee e) -> {
            if (e.getSalary() > 4500) return "HIGH";
            else return "LOWER";
        }));
        System.out.println(collect3);
        Map<String, Map<String, List<Employee>>> collect4 = employees.stream().collect(Collectors.groupingBy((Employee e) -> {
            if (e.getSalary() > 4500) return "HIGH";
            else return "LOWER";
        }, Collectors.groupingBy((Employee e) -> {
            if (e.getAge() > 30) return "OLDER";
            else return "YOUNGER";
        })));
        System.out.println(collect4);

        System.out.println("--------reduce-------------");
        Double reduce1 = employees.stream().map(Employee::getSalary).reduce(0.0, (x, y) -> x + y);
        System.out.println(reduce1);
        Optional<Double> reduce = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce.get());
    }

    public static Stream<Character> filterCharactor(String string) {
        List<Character> list = new ArrayList<>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
