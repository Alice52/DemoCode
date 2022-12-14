package cn.edu.ntu.java.javase.interview.abc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-03-01 17:45 <br>
 * @project javase <br>
 */
@Slf4j
public class ABABWithLock {

    @SneakyThrows
    public static void main(String[] args) {
        ResourceWithLock withLock = new ResourceWithLock();
        IntStream.rangeClosed(1, 5).forEach(i -> new Thread(withLock::produce).start());
        IntStream.rangeClosed(1, 5).forEach(i -> new Thread(withLock::consume).start());
    }
}

@Slf4j
class ResourceWithLock extends AbstractResource {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @SneakyThrows
    @Override
    public void produce() {
        lock.lock();
        try {
            while (number >= MAX_COUNT) {
                condition.await();
            }
            ++number;
            log.info("produce number is {}", number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    @Override
    public void consume() {

        lock.lock();
        try {
            while (number <= 0) {
                condition.await();
            }
            --number;
            log.info("consume number is {}", number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
