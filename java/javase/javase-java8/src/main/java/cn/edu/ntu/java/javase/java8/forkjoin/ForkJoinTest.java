package cn.edu.ntu.java.javase.java8.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author zack <br>
 * @create 2020-04-04 19:41 <br>
 */
@Slf4j
public class ForkJoinTest extends RecursiveTask<Long> {

    private static final long THRESHOLD = 10000000L;
    private long start;
    private long end;

    public ForkJoinTest() {}

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinTest(0, 1000000000L);
        forkJoinPool.invoke(task);
        Instant end = Instant.now();
        // 228
        log.info(Duration.between(start, end).toMillis() + "");

        Instant start1 = Instant.now();
        long sum = 0;
        for (int i = 0; i <= 1000000000L; i++) {
            sum += i;
        }
        Instant end1 = Instant.now();
        // 542
        log.info(Duration.between(start1, end1).toMillis() + "");

        Instant start2 = Instant.now();
        // 638
        LongStream.rangeClosed(0, 1000000000L).reduce(Long::sum);
        Instant end2 = Instant.now();
        log.info(Duration.between(start2, end2).toMillis() + "");

        Instant start3 = Instant.now();
        LongStream.rangeClosed(0, 1000000000L).parallel().reduce(Long::sum);
        Instant end3 = Instant.now();
        //  393
        log.info(Duration.between(start3, end3).toMillis() + "");
    }

    @Override
    protected Long compute() {
        long length = end - start;
        long sum = 0;
        if (length <= THRESHOLD) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 拆分: 递归
            long middle = (start + end) / 2;
            ForkJoinTest forkJoinLeft = new ForkJoinTest(start, middle);
            forkJoinLeft.fork(); // 进行拆分并压如栈
            ForkJoinTest forkJoinRight = new ForkJoinTest(middle + 1, end);
            forkJoinRight.fork(); // 进行拆分并压如栈
            return forkJoinLeft.join() + forkJoinRight.join();
        }
    }
}
