package cn.edu.ntu.javase.interview.queue;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-03-01 17:05 <br>
 * @project javase <br>
 */
@Slf4j
public class BlockingQueueTest {
    static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {

        OptionalInt.of(bq.size()).ifPresent(System.out::println);
        OptionalInt.of(bq.remainingCapacity()).ifPresent(System.out::println);

        new SynchronousQueue<>();
    }

    @SneakyThrows
    @Test
    public void blocking() {
        // put
        bq.put(5);
        bq.put(7);
        bq.put(8);

        // take
        Optional.of(bq.take()).ifPresent(System.out::println);
        Optional.of(bq.take()).ifPresent(System.out::println);
        Optional.of(bq.take()).ifPresent(System.out::println);

        bq.put(6);
        Optional.of(bq.take()).ifPresent(System.out::println);
    }

    @SneakyThrows
    @Test
    public void boolWithTimeout() {

        // offer
        Optional.of(bq.offer(51, 2, TimeUnit.SECONDS)).ifPresent(System.out::println);
        Optional.of(bq.offer(61, 2, TimeUnit.SECONDS)).ifPresent(System.out::println);
        Optional.of(bq.offer(71, 2, TimeUnit.SECONDS)).ifPresent(System.out::println);
        Optional.of(bq.offer(81, 2, TimeUnit.SECONDS)).ifPresent(System.out::println);

        // poll
        Optional.of(Optional.ofNullable(bq.poll(2, TimeUnit.SECONDS)).orElse(-11))
                .ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.poll(2, TimeUnit.SECONDS)).orElse(-11))
                .ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.poll(2, TimeUnit.SECONDS)).orElse(-11))
                .ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.poll(2, TimeUnit.SECONDS)).orElse(-11))
                .ifPresent(System.out::println);
    }

    @Test
    public void bool() {

        // offer
        Optional.of(bq.offer(5)).ifPresent(System.out::println);
        Optional.of(bq.offer(6)).ifPresent(System.out::println);
        Optional.of(bq.offer(7)).ifPresent(System.out::println);
        Optional.of(bq.offer(8)).ifPresent(System.out::println);

        // poll
        Optional.of(Optional.ofNullable(bq.poll()).orElse(-1)).ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.poll()).orElse(-1)).ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.peek()).orElse(-1)).ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.poll()).orElse(-1)).ifPresent(System.out::println);
        Optional.of(Optional.ofNullable(bq.poll()).orElse(-1)).ifPresent(System.out::println);

        // peek
        Optional.of(Optional.ofNullable(bq.peek()).orElse(-1)).ifPresent(System.out::println);
    }

    @Test
    public void exception() {

        // add()
        Optional.of(bq.add(5)).ifPresent(System.out::println);
        Optional.of(bq.add(6)).ifPresent(System.out::println);
        Optional.of(bq.add(7)).ifPresent(System.out::println);
        // java.lang.IllegalStateException: Queue full
        // Optional.of(bq.add(8)).ifPresent(System.out::println);

        // remove
        Optional.ofNullable(bq.remove()).ifPresent(System.out::println);
        Optional.ofNullable(bq.element()).ifPresent(System.out::println);
        Optional.ofNullable(bq.remove()).ifPresent(System.out::println);
        Optional.ofNullable(bq.remove()).ifPresent(System.out::println);
        // java.util.NoSuchElementException
        // Optional.ofNullable(bq.remove()).ifPresent(System.out::println);

        // check
        // Optional.ofNullable(bq.element()).ifPresent(System.out::println);
    }
}
