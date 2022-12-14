package cn.edu.ntu.java.javase.java8.stream.collector;

import cn.edu.ntu.java.javase.common.model.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author zack <br>
 * @create 2020-04-04 20:46 <br>
 */
@Slf4j
public class CollectorTest {

    private static final List<Apple> APPLES =
            Arrays.asList(
                    new Apple("red", 120),
                    new Apple("red", 85),
                    new Apple("red", 50),
                    new Apple("green", 20),
                    new Apple("red", 45),
                    new Apple("yellow", 456),
                    new Apple("red", 125));

    @Test
    public void testProcessingOperation() {
        List<String> collect =
                APPLES.stream()
                        .filter(apple -> apple.getWeight() > 50)
                        .map(Apple::getColor)
                        .collect(toList());

        collect.forEach(System.out::println);
    }

    @Test
    public void groupByColor() {
        Map<String, List<Apple>> map = new HashMap<>(16);

        for (Apple apple : APPLES) {
            List<Apple> list = map.get(apple.getColor());
            if (list == null) {
                list = new ArrayList<>();
                map.put(apple.getColor(), list);
            }
            list.add(apple);
        }
        log.info(map.toString());
    }

    @Test
    public void groupByColorFunction() {

        final Map<String, List<Apple>> map = new HashMap<>(16);
        APPLES.stream()
                .forEach(
                        apple -> {
                            List<Apple> apples =
                                    Optional.ofNullable(map.get(apple.getColor()))
                                            .orElseGet(
                                                    () -> {
                                                        List<Apple> arrayList = new ArrayList<>();
                                                        map.put(apple.getColor(), arrayList);
                                                        return arrayList;
                                                    });
                            // this use space reference
                            // apples is put to map when first element
                            apples.add(apple);
                        });

        log.info(map.toString());
    }

    @Test
    public void testCollector() {
        Map<String, List<Apple>> collect =
                APPLES.stream().collect(Collectors.groupingBy(Apple::getColor));
        collect.forEach((color, list) -> log.info(color + list));
    }

    @Test
    public void testAveragingXx() {
        Optional.ofNullable(APPLES.stream().collect(Collectors.averagingDouble(Apple::getWeight)))
                .ifPresent(System.out::println);
        Optional.ofNullable(APPLES.stream().collect(Collectors.averagingInt(Apple::getWeight)))
                .ifPresent(System.out::println);
        Optional.ofNullable(APPLES.stream().collect(Collectors.averagingLong(Apple::getWeight)))
                .ifPresent(System.out::println);
    }

    @Test
    public void testCollectingAndThen() {
        Optional.ofNullable(
                        APPLES.stream()
                                .collect(
                                        Collectors.collectingAndThen(
                                                Collectors.averagingDouble(Apple::getWeight),
                                                avg -> "the avg is " + avg)))
                .ifPresent(System.out::println);

        List<Apple> appleList =
                APPLES.stream()
                        .filter(apple -> apple.getWeight() > 100)
                        .collect(
                                Collectors.collectingAndThen(
                                        Collectors.toList(), Collections::unmodifiableList));

        // appleList.add(new Apple()); // UnsupportedOperationException
    }

    @Test
    public void testCounting() {
        Optional.of(APPLES.stream().collect(Collectors.counting())).ifPresent(System.out::println);
        Optional.of(APPLES.stream().count()).ifPresent(System.out::println);
    }

    @Test
    public void testGroupByFunction() {
        Map<String, List<Apple>> collect =
                APPLES.stream().collect(Collectors.groupingBy(Apple::getColor));
        Optional.of(collect).ifPresent(System.out::println);
    }

    @Test
    public void testGroupByFunctionAndCollector() {

        Map<String, Long> collect =
                APPLES.stream()
                        .collect(Collectors.groupingBy(Apple::getColor, Collectors.counting()));
        collect.forEach((color, count) -> log.info(color + count));
        Optional.of(collect).ifPresent(System.out::println);
    }

    @Test
    public void testGroupByFunctionAndSupplierAndCollector() {
        Map<String, Double> map =
                APPLES.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Apple::getColor,
                                        TreeMap::new,
                                        Collectors.averagingDouble(Apple::getWeight)));

        Optional.ofNullable(map.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(map).ifPresent(System.out::println);
    }

    @Test
    public void testGroupingByConcurrent() {

        ConcurrentMap<String, List<Apple>> listConcurrentMap =
                APPLES.stream().collect(Collectors.groupingByConcurrent(Apple::getColor));
        Optional.ofNullable(listConcurrentMap).ifPresent(System.out::println);
    }

    @Test
    public void testGroupingByConcurrentAndSupplier() {

        ConcurrentSkipListMap<String, Double> concurrentSkipListMap =
                APPLES.stream()
                        .collect(
                                Collectors.groupingByConcurrent(
                                        Apple::getColor,
                                        ConcurrentSkipListMap::new,
                                        Collectors.averagingInt(Apple::getWeight)));
        Optional.ofNullable(concurrentSkipListMap).ifPresent(System.out::println);
    }

    @Test
    public void testJoining() {
        String collect = APPLES.stream().map(Apple::getColor).collect(Collectors.joining());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testJoiningWithDelimiter() {
        String collect = APPLES.stream().map(Apple::getColor).collect(Collectors.joining(";"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testJoiningWithDelimiterAndFix() {
        String collect =
                APPLES.stream().map(Apple::getColor).collect(Collectors.joining(";", "--", "**"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testMaxBy() {
        Optional<Apple> collect =
                APPLES.stream()
                        .collect(Collectors.maxBy(Comparator.comparingInt(Apple::getWeight)));
        collect.ifPresent(System.out::println);
    }

    @Test
    public void testMapping() {
        Long collect =
                APPLES.stream()
                        .collect(Collectors.mapping(Apple::getWeight, Collectors.counting()));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testPartitionBy() {
        Map<Boolean, Double> collect =
                APPLES.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        a -> a.getWeight() > 200,
                                        Collectors.averagingInt(Apple::getWeight)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testReducing() {
        Optional<Apple> collect =
                APPLES.stream()
                        .collect(
                                Collectors.reducing(
                                        BinaryOperator.maxBy(
                                                Comparator.comparingInt(Apple::getWeight))));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testReducingWithFunction() {
        Integer integer =
                APPLES.stream().collect(Collectors.reducing(0, Apple::getWeight, (a, b) -> a + b));
        Integer integer2 =
                APPLES.stream()
                        .map(Apple::getWeight)
                        .collect(Collectors.reducing(0, (a, b) -> a + b));
        Optional.ofNullable(integer).ifPresent(System.out::println);
    }

    @Test
    public void testSummaryStatistics() {
        DoubleSummaryStatistics summaryStatistics =
                APPLES.stream().collect(Collectors.summarizingDouble(Apple::getWeight));
        Optional.ofNullable(summaryStatistics).ifPresent(System.out::println);
    }

    @Test
    public void testSummingInt() {
        Integer collect = APPLES.stream().collect(Collectors.summingInt(Apple::getWeight));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testToCollection() {
        Collection<Apple> collect =
                APPLES.stream()
                        .filter(apple -> apple.getColor().equals("green"))
                        .collect(Collectors.toCollection(LinkedList::new));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testToConcurrentMap() {
        ConcurrentMap<Integer, String> collect =
                APPLES.stream()
                        .collect(Collectors.toConcurrentMap(Apple::getWeight, Apple::getColor));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testToConcurrentMapWithBinaryOperator() {
        ConcurrentSkipListMap<String, Long> collect =
                APPLES.stream()
                        .collect(
                                Collectors.toConcurrentMap(
                                        Apple::getColor,
                                        v -> 1L,
                                        (a, b) -> a + b,
                                        ConcurrentSkipListMap::new));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testToList() {
        List<Apple> collect = APPLES.stream().collect(Collectors.toList());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testToSet() {
        Set<Apple> collect = APPLES.stream().collect(Collectors.toSet());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    @Test
    public void testToMap() {
        ConcurrentSkipListMap<Integer, Long> collect =
                APPLES.stream()
                        .collect(
                                Collectors.toMap(
                                        Apple::getWeight,
                                        v -> 1L,
                                        (a, b) -> a + b,
                                        ConcurrentSkipListMap::new));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
}
