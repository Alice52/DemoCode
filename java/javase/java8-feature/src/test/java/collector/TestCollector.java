package collector;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zack
 * @create 2019-11-19 21:48
 * @function
 */
public class TestCollector {

  class Apple {
    private String color;
    private int weght;

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public int getWeght() {
      return weght;
    }

    public void setWeght(int weght) {
      this.weght = weght;
    }

    public Apple() {}

    public Apple(String color, int weght) {
      this.color = color;
      this.weght = weght;
    }

    @Override
    public String toString() {
      return "Apple{" + "color='" + color + '\'' + ", weght=" + weght + '}';
    }
  }

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

    Optional.ofNullable(apples.stream().collect(Collectors.averagingDouble(Apple::getWeght)))
        .ifPresent(System.out::println);
    Optional.ofNullable(apples.stream().collect(Collectors.averagingInt(Apple::getWeght)))
        .ifPresent(System.out::println);
    Optional.ofNullable(apples.stream().collect(Collectors.averagingLong(Apple::getWeght)))
        .ifPresent(System.out::println);
  }

  @Test
  public void testCollectingAndThen() {
    Optional.ofNullable(
            apples.stream()
                .collect(
                    Collectors.collectingAndThen(
                        Collectors.averagingDouble(Apple::getWeght), avg -> "the avg is " + avg)))
        .ifPresent((System.out::println));

    List<Apple> appleList =
        apples.stream()
            .filter(apple -> apple.getWeght() > 100)
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
                    Apple::getColor, TreeMap::new, Collectors.averagingDouble(Apple::getWeght)));

      Optional.ofNullable(map.getClass()).ifPresent(System.out::println);
      Optional.ofNullable(map).ifPresent(System.out::println);
  }


  @Test
  public void test() {
      IntSummaryStatistics intSummaryStatistics = apples.stream().collect(Collectors.summarizingInt(Apple::getWeght));
      Optional.ofNullable(intSummaryStatistics).ifPresent(System.out::println);
  }
}
