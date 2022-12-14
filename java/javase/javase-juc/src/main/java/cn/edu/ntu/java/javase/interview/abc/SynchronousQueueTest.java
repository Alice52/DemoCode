package cn.edu.ntu.java.javase.interview.abc;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-03-01 17:27 <br>
 * @project javase <br>
 */
@Slf4j
public class SynchronousQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new SynchronousQueue<>();

        OptionalInt.of(bq.remainingCapacity()).ifPresent(System.out::println);

        new Thread(
                        () -> {
                            try {
                                log.info("put 50");
                                bq.offer(50, 1, TimeUnit.SECONDS);

                                log.info("put 51");
                                bq.offer(51, 1, TimeUnit.SECONDS);

                                log.info("put 52");
                                bq.offer(52, 1, TimeUnit.SECONDS);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        },
                        "AA")
                .start();

        new Thread(
                        () -> {
                            try {
                                Optional.of(bq.poll(1, TimeUnit.SECONDS))
                                        .ifPresent(System.out::println);
                                Optional.of(bq.poll(1, TimeUnit.SECONDS))
                                        .ifPresent(System.out::println);
                                Optional.of(bq.poll(1, TimeUnit.SECONDS))
                                        .ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        },
                        "BB")
                .start();
    }
}
