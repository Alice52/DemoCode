package stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zack
 * @create 2019-11-18 21:27
 * @function
 */
public class TestStream {
  private List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

  @Test
  public void testProcessingOperation() {
    List<String> collect =
        integers.stream()
            .filter(
                integer -> {
                  System.out.println("filter: " + integer);
                  return integer > 2;
                })
            .map(
                t -> {
                  System.out.println("map: " + t);
                  return t.toString();
                })
            .collect(toList());
  }

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
  public void testStreamFlatMap() {
    String[] words = {"Hello", "world"};

    // {H, e, l, l, o}, {w, o, r, l, d}
    Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));

    // Stream<String> stringStream = stream.flatMap(t -> Stream.of(t));
    Stream<String> stringStream = stream.flatMap(Arrays::stream);

    stringStream.forEach(System.out::println);
  }

  @Test
  public void testMatch() {
    boolean anyMatch = integers.stream().anyMatch(i -> i > 4);
    assert anyMatch : "exist element gt 4";

    boolean matched = integers.stream().allMatch(i -> i < 6);
    assert matched : "all element lt 6";

    boolean noneMatch = integers.stream().noneMatch(i -> i < 1);
    assert noneMatch : "no element lt 1";
  }

  @Test
  public void testFind() {
    Optional<Integer> optionalInteger = integers.stream().filter(i -> i == 2).findAny();
    Optional<Integer> optionalInteger1 = integers.stream().filter(i -> i == 2).findFirst();
  }

  @Test
  public void testMap() {
    int a = 3;
    IntStream.rangeClosed(1, 100)
        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
        .boxed()
        .map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
        .forEach(arr -> System.out.println("a: " + arr[0] + ", b: " + arr[1] + " c:" + arr[2]));
  }
}
