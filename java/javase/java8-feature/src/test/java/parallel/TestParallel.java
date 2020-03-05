package parallel;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author zack
 * @create 2019-11-21 21:09
 * @function
 */
public class TestParallel {

  @Test
  public void getProcessor() {

    int processors = Runtime.getRuntime().availableProcessors();
    System.out.println(processors);

    System.out.print(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
    System.out.print(System.getProperty("java.util.concurrent.ForkJoinPool.common.threadFactory"));
    System.out.print(
        System.getProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler"));

    System.out.println(
        "normal add consume time: " + testCompareParallel(TestParallel::testNormalAdd, 10000000));
    System.out.println(
        "iterate stream add consume time: "
            + testCompareParallel(TestParallel::testIterateStream, 10000000));
    System.out.println(
        "parallel stream without box add consume time: "
            + testCompareParallel(TestParallel::testParallelStreamWithoutBox, 10000000));
    System.out.println(
        "parallel stream built in add consume time: "
            + testCompareParallel(TestParallel::testParallelBuiltin, 10000000));
    System.out.println(
        "parallel stream built in add consume time: "
            + testCompareParallel(TestParallel::testParallelBuiltin2, 10000000));

    //      normal add consume time:                            3589700
    //      iterate stream add consume time:                   90266100
    //      parallel stream without box add consume time:      80533400
    //      parallel stream built in add consume time:          1355000
    //      parallel stream built in add consume time:          8340600

  }

  private static long testCompareParallel(Function<Long, Long> way, long limit) {
    long fastest = Long.MAX_VALUE;

    for (int i = 0; i < 10; i++) {
      long startTime = System.nanoTime();
      way.apply(limit);
      long duration = System.nanoTime() - startTime;

      if (duration < fastest) fastest = duration;
    }

    return fastest;
  }

  private static long testIterateStream(long limit) {
    return Stream.iterate(0L, i -> i + 1).limit(limit).reduce(0L, Long::sum);
  }

  private static long testParallelStreamWithoutBox(long limit) {
    return Stream.iterate(0L, i -> i + 1)
        .limit(limit)
        .mapToLong(Long::longValue)
        .reduce(0L, Long::sum);
  }

  private static long testParallelBuiltin(long limit) {
    return LongStream.rangeClosed(1, limit).parallel().reduce(0L, Long::sum);
  }

  private static long testParallelBuiltin2(long limit) {
    return LongStream.rangeClosed(1, limit).parallel().sum();
  }

  private static long testNormalAdd(long limit) {
    long result = 0L;
    for (long i = 0; i < limit; ++i) {
      result += i;
    }
    return result;
  }
}
