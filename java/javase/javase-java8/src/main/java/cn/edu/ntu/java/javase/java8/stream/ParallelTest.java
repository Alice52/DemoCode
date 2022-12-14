package cn.edu.ntu.java.javase.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author zack <br>
 * @create 2020-04-04 21:38 <br>
 */
@Slf4j
public class ParallelTest {

    private static long testCompareParallel(Function<Long, Long> way, long limit) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            way.apply(limit);
            long duration = System.nanoTime() - startTime;

            if (duration < fastest) {
                fastest = duration;
            }
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

    @Test
    public void getProcessor() {

        int processors = Runtime.getRuntime().availableProcessors();
        log.info(processors + "");

        log.info(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
        log.info(System.getProperty("java.util.concurrent.ForkJoinPool.common.threadFactory"));
        log.info(System.getProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler"));

        log.info(
                "normal add consume time: "
                        + testCompareParallel(ParallelTest::testNormalAdd, 10000000));
        log.info(
                "iterate stream add consume time: "
                        + testCompareParallel(ParallelTest::testIterateStream, 10000000));
        log.info(
                "parallel stream without box add consume time: "
                        + testCompareParallel(
                                ParallelTest::testParallelStreamWithoutBox, 10000000));
        log.info(
                "parallel stream built in add consume time: "
                        + testCompareParallel(ParallelTest::testParallelBuiltin, 10000000));
        log.info(
                "parallel stream built in add consume time: "
                        + testCompareParallel(ParallelTest::testParallelBuiltin2, 10000000));

        //      normal add consume time:                            3589700
        //      iterate stream add consume time:                   90266100
        //      parallel stream without box add consume time:      80533400
        //      parallel stream built in add consume time:          1355000
        //      parallel stream built in add consume time:          8340600

    }
}
