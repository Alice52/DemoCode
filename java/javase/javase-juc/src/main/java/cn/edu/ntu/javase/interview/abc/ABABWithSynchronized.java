package cn.edu.ntu.javase.interview.abc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-03-01 17:45 <br>
 * @project javase <br>
 */
@Slf4j
public class ABABWithSynchronized {

    @SneakyThrows
    public static void main(String[] args) {
        ResourceWithSynchronized v1 = new ResourceWithSynchronized();
        IntStream.rangeClosed(1, 5).forEach(i -> new Thread(v1::produce, "AA" + i).start());
        IntStream.rangeClosed(1, 5).forEach(i -> new Thread(v1::consume, "BB" + i).start());
        TimeUnit.SECONDS.sleep(1);
        OptionalInt.of(v1.number).ifPresent(System.out::println);
    }
}

@Slf4j
class ResourceWithSynchronized extends AbstractResource {

    @Override
    @SneakyThrows
    public synchronized void produce() {

        while (number >= MAX_COUNT) {
            this.wait();
        }
        number++;
        log.info("produce number is {}", number);
        this.notifyAll();
    }

    @Override
    @SneakyThrows
    public synchronized void consume() {
        while (number <= 0) {
            this.wait();
        }
        number--;
        log.info("consume number is {}", number);
        this.notifyAll();
    }
}
