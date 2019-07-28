import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author zack
 * @create 2019-05-31 13:36
 * @function test ForkJoin framework
 */
public class ForkJoin extends RecursiveTask<Long> {

    private long start;
    private long end;
    private static final long THRESHOLD = 10000000L;

    public ForkJoin() {
    }

    public ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
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
            ForkJoin forkJoinLeft = new ForkJoin(start, middle);
            forkJoinLeft.fork(); // 进行拆分并压如栈
            ForkJoin forkJoinRight = new ForkJoin(middle + 1, end);
            forkJoinRight.fork(); // 进行拆分并压如栈
            return forkJoinLeft.join() + forkJoinRight.join();
        }
    }


    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoin(0, 1000000000L);
        forkJoinPool.invoke(task);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());  // 228

        Instant start1 = Instant.now();
        long sum = 0;
        for (int i = 0; i <= 1000000000L; i++) {
            sum += i;
        }
        Instant end1 = Instant.now();
        System.out.println(Duration.between(start1, end1).toMillis());  // 542

        Instant start2 = Instant.now();
        LongStream.rangeClosed(0, 1000000000L).reduce(Long::sum);  // 638
        Instant end2 = Instant.now();
        System.out.println(Duration.between(start2, end2).toMillis());

        Instant start3 = Instant.now();
        LongStream.rangeClosed(0, 1000000000L).parallel().reduce(Long::sum);
        Instant end3 = Instant.now();
        System.out.println(Duration.between(start3, end3).toMillis()); //  393

    }
}
