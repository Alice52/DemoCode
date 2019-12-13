package collector;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author zack
 * @create 2019-11-19 21:48
 * @function
 */
public class TestCollector {

  private List<Apple> apples =
      Arrays.asList(
          new Apple("red", 120),
          new Apple("red", 85),
          new Apple("red", 50),
          new Apple("green", 20),
          new Apple("red", 45),
          new Apple("yellow", 456),
          new Apple("red", 125));

  @Test
  public void testCollector() {
    apples.stream()
        .collect(Collectors.groupingBy(Apple::getColor))
        .forEach((color, list) -> System.out.println(color + list));
  }

  @Test
  public void groupByColor() {
    Map<String, List<Apple>> map = new HashMap<>();

    for (Apple apple : apples) {
      List<Apple> list = map.get(apple.getColor());
      if (list == null) {
        list = new ArrayList<>();
        map.put(apple.getColor(), list);
      }
      list.add(apple);
    }
    System.out.print(map);
  }

  @Test
  public void groupByColorFunction() {

    final Map<String, List<Apple>> map = new HashMap<>();
    apples.stream()
        .forEach(
            apple -> {
              List<Apple> apples =
                  Optional.ofNullable(map.get(apple.getColor()))
                      .orElseGet(
                          () -> {
                            ArrayList<Apple> arrayList = new ArrayList<>();
                            map.put(apple.getColor(), arrayList);
                            return arrayList;
                          });
              apples.add(apple);
            });

    System.out.println(map);
  }

  @Test
  public void testAveragingXx() {

    Optional.ofNullable(apples.stream().collect(Collectors.averagingDouble(Apple::getWeight)))
        .ifPresent(System.out::println);
    Optional.ofNullable(apples.stream().collect(Collectors.averagingInt(Apple::getWeight)))
        .ifPresent(System.out::println);
    Optional.ofNullable(apples.stream().collect(Collectors.averagingLong(Apple::getWeight)))
        .ifPresent(System.out::println);
  }

  @Test
  public void testCollectingAndThen() {
    Optional.ofNullable(
            apples.stream()
                .collect(
                    Collectors.collectingAndThen(
                        Collectors.averagingDouble(Apple::getWeight), avg -> "the avg is " + avg)))
        .ifPresent((System.out::println));

    List<Apple> appleList =
        apples.stream()
            .filter(apple -> apple.getWeight() > 100)
            .collect(
                Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

    // appleList.add(new Apple()); // UnsupportedOperationException
  }

  @Test
  public void testCounting() {
    Optional.of(apples.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    Optional.of(apples.stream().count()).ifPresent(System.out::println);
  }

  @Test
  public void testGroupByFunction() {
    Map<String, List<Apple>> collect =
        apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    Optional.of(collect).ifPresent(System.out::println);
  }

  @Test
  public void testGroupByFunctionAndCollector() {

    Map<String, Long> collect =
        apples.stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.counting()));
    collect.forEach((color, count) -> System.out.println(color + count));
    Optional.of(collect).ifPresent(System.out::println);
  }

  @Test
  public void testGroupByFunctionAndSupplierAndCollector() {
    Map<String, Double> map =
        apples.stream()
            .collect(
                Collectors.groupingBy(
                    Apple::getColor, TreeMap::new, Collectors.averagingDouble(Apple::getWeight)));

    Optional.ofNullable(map.getClass()).ifPresent(System.out::println);
    Optional.ofNullable(map).ifPresent(System.out::println);
  }

  @Test
  public void testGroupingByConcurrent() {

    ConcurrentMap<String, List<Apple>> listConcurrentMap =
        apples.stream().collect(Collectors.groupingByConcurrent(Apple::getColor));
    Optional.ofNullable(listConcurrentMap).ifPresent(System.out::println);
  }

  @Test
  public void testGroupingByConcurrentAndSupplier() {

    ConcurrentSkipListMap<String, Double> concurrentSkipListMap =
        apples.stream()
            .collect(
                Collectors.groupingByConcurrent(
                    Apple::getColor,
                    ConcurrentSkipListMap::new,
                    Collectors.averagingInt(Apple::getWeight)));
    Optional.ofNullable(concurrentSkipListMap).ifPresent(System.out::println);
  }

  @Test
  public void testJoining() {
    String collect = apples.stream().map(Apple::getColor).collect(Collectors.joining());
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testJoiningWithDelimiter() {
    String collect = apples.stream().map(Apple::getColor).collect(Collectors.joining(";"));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testJoiningWithDelimiterAndFix() {
    String collect =
        apples.stream().map(Apple::getColor).collect(Collectors.joining(";", "--", "**"));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testMaxBy() {
    Optional<Apple> collect =
        apples.stream().collect(Collectors.maxBy(Comparator.comparingInt(Apple::getWeight)));
    collect.ifPresent(System.out::println);
  }

  @Test
  public void testMapping() {
    Long collect =
        apples.stream().collect(Collectors.mapping(Apple::getWeight, Collectors.counting()));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testPartitionBy() {
    Map<Boolean, Double> collect =
        apples.stream()
            .collect(
                Collectors.partitioningBy(
                    a -> a.getWeight() > 200, Collectors.averagingInt(Apple::getWeight)));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testReducing() {
    Optional<Apple> collect =
        apples.stream()
            .collect(
                Collectors.reducing(
                    BinaryOperator.maxBy(Comparator.comparingInt(Apple::getWeight))));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testReducingWithFunction() {
    Integer integer =
        apples.stream().collect(Collectors.reducing(0, Apple::getWeight, (a, b) -> a + b));
    Integer integer2 =
        apples.stream().map(Apple::getWeight).collect(Collectors.reducing(0, (a, b) -> a + b));
    Optional.ofNullable(integer).ifPresent(System.out::println);
  }

  @Test
  public void testSummaryStatistics() {
    DoubleSummaryStatistics summaryStatistics =
        apples.stream().collect(Collectors.summarizingDouble(Apple::getWeight));
    Optional.ofNullable(summaryStatistics).ifPresent(System.out::println);
  }

  @Test
  public void testSummingInt() {
    Integer collect = apples.stream().collect(Collectors.summingInt(Apple::getWeight));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testToCollection() {
    Collection<Apple> collect =
        apples.stream()
            .filter(apple -> apple.getColor().equals("green"))
            .collect(Collectors.toCollection(LinkedList::new));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testToConcurrentMap() {
    ConcurrentMap<Integer, String> collect =
        apples.stream().collect(Collectors.toConcurrentMap(Apple::getWeight, Apple::getColor));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testToConcurrentMapWithBinaryOperator() {
    ConcurrentSkipListMap<String, Long> collect =
        apples.stream()
            .collect(
                Collectors.toConcurrentMap(
                    Apple::getColor, v -> 1L, (a, b) -> a + b, ConcurrentSkipListMap::new));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testToList() {
    List<Apple> collect = apples.stream().collect(Collectors.toList());
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testToSet() {
    Set<Apple> collect = apples.stream().collect(Collectors.toSet());
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  @Test
  public void testToMap() {
    ConcurrentSkipListMap<Integer, Long> collect =
        apples.stream()
            .collect(
                Collectors.toMap(
                    Apple::getWeight, v -> 1L, (a, b) -> a + b, ConcurrentSkipListMap::new));
    Optional.ofNullable(collect).ifPresent(System.out::println);
  }

  class Apple {
    private String color;
    private int weight;

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public Apple() {}

    public Apple(String color, int weght) {
      this.color = color;
      this.weight = weght;
    }

    @Override
    public String toString() {
      return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }
  }
}
