package cn.edu.ntu.javase.java8.stream;

import cn.edu.ntu.javase.common.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zack <br>
 * @create 2020-04-04 20:08 <br>
 */
@Slf4j
public class StreamTest {
  private static final List<Employee> EMPLOYEES =
      Arrays.asList(
          new Employee("张壮", 18, 6500),
          new Employee("练顺", 8, 3000),
          new Employee("王凡", 38, 6000),
          new Employee("张程", 58, 8000));

  private static Stream<Character> filterCharacter(String string) {
    List<Character> list = new ArrayList<>();
    for (char c : string.toCharArray()) {
      list.add(c);
    }
    return list.stream();
  }

  @Test
  /** 创建 Stream */
  public void testCreate() {
    // 1. 通过 Collection 系列集合的 stream() 或 parallelStream()
    List<String> stringList = new ArrayList<>();
    Stream<String> stringStream = stringList.stream();
    // 2. 通过 Arrays 中的静态方法 stream() 获取数组流
    Employee[] emps = new Employee[10];
    Stream<Employee> employeeStream = Arrays.stream(emps);

    // 3. 通过 Stream 类中的静态方法 of() 获取
    Stream<String> stringStream1 = Stream.of("aa", "bb", "cc");
    stringStream1.forEach(System.out::println);

    // 4. 创建无限流
    // 4.1 迭代: seed ---> 开始位置;
    Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2).limit(50);
    // 4.2 生成
    Stream<Integer> integerStream2 = Stream.generate(() -> (int) (Math.random() * 100)).limit(50);
  }

  @Test
  public void testFilter() {
    Stream<Employee> stream = EMPLOYEES.stream();
    // 找到两个满足添加之后的就停止运算
    stream.filter(e -> e.getAge() > 30).limit(2).forEach(System.out::println);
  }

  @Test
  public void testSkip() {
    Stream<Employee> stream = EMPLOYEES.stream();
    stream.filter(e -> e.getAge() > 30).skip(2).forEach(System.out::println);
  }

  @Test
  public void testMap() {
    Stream<Employee> stream = EMPLOYEES.stream();
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
        .forEach(arr -> System.out.println("a: " + arr[0] + ", b: " + arr[1] + " c:" + arr[2]));
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
    stream.forEach(x -> Arrays.asList(x).stream().forEach(System.out::println));

    Stream<String[]> stream2 = Arrays.stream(words).map(w -> w.split(" "));
    Stream<String> stringStream = stream2.flatMap(Arrays::stream);
    stringStream.forEach(System.out::println);

    Stream<String[]> stream3 = Arrays.stream(words).map(w -> w.split(" "));
    Stream<String> strStream = stream3.flatMap(t -> Stream.of(t));
    strStream.forEach(System.out::println);
  }

  @Test
  public void testReduce() {
    Double reduce1 = EMPLOYEES.stream().map(Employee::getSalary).reduce(0.0, (x, y) -> x + y);
    log.info(reduce1.toString());

    List<Employee> list = new ArrayList<>();
    Optional<Double> reduce = list.stream().map(Employee::getSalary).reduce(Double::sum);
    reduce.ifPresent(System.out::println);
  }

  @Test
  public void testSort() {
    List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd");
    list.stream().sorted().forEach(System.out::println);
    EMPLOYEES.stream()
        .sorted(Comparator.comparingInt(x -> (int) (-x.getAge())))
        .forEach(System.out::println);
  }

  @Test
  public void testCollect() {

    List<String> collect = EMPLOYEES.stream().map(Employee::getName).collect(toList());
    collect.forEach(System.out::println);

    HashSet<String> collect1 =
        EMPLOYEES.stream()
            .map(Employee::getName)
            .collect(Collectors.toCollection(() -> new HashSet<>()));
    HashSet<String> collect2 =
        EMPLOYEES.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
    collect2.forEach(System.out::println);

    Map<String, List<Employee>> collect3 =
        EMPLOYEES.stream()
            .collect(
                Collectors.groupingBy(
                    (Employee e) -> {
                      if (e.getSalary() > 4500) {
                        return "HIGH";
                      } else {
                        return "LOWER";
                      }
                    }));
    log.info(collect3.toString());

    Map<String, Map<String, List<Employee>>> collect4 =
        EMPLOYEES.stream()
            .collect(
                Collectors.groupingBy(
                    (Employee e) -> {
                      if (e.getSalary() > 4500) {
                        return "HIGH";
                      } else {
                        return "LOWER";
                      }
                    },
                    Collectors.groupingBy(
                        (Employee e) -> {
                          if (e.getAge() > 30) {
                            return "OLDER";
                          } else {
                            return "YOUNGER";
                          }
                        })));
    log.info(collect4.toString());
  }

  //  private List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

  @Test
  public void testStreamIO() {
    Path path = Paths.get("pom.xml");

    try (Stream<String> lines = Files.lines(path)) {
      lines.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testMatch() {
    boolean anyMatch = EMPLOYEES.stream().anyMatch(x -> x.getAge() > 4);
    assert anyMatch : "exist element gt 4";

    boolean matched = EMPLOYEES.stream().allMatch(i -> i.getAge() < 6);
    assert !matched : "not all element lt 6";

    boolean noneMatch = EMPLOYEES.stream().noneMatch(i -> i.getAge() < 1);
    assert noneMatch : "no element lt 1";
  }

  @Test
  public void testFind() {
    Optional<Employee> employee = EMPLOYEES.stream().filter(i -> i.getAge() == 2).findAny();
    EMPLOYEES.stream().filter(i -> i.getAge() == 18).findFirst().ifPresent(System.out::println);
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
            .collect(HashMap::new, (m, v) -> m.put(v.getAge(), v.getName()), HashMap::putAll);

    log.info("map: {}", collect);
  }
}
