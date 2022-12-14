package cn.edu.ntu.java.javase.interview.abc.v2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author asd <br>
 * @create 2021-12-08 4:56 PM <br>
 * @project javase <br>
 */
@Slf4j
public class ABCLockCondition {

    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();
    private int num = 1;

    @SneakyThrows
    @Test
    public void testV1() {
        ABCLockCondition print = new ABCLockCondition();
        new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> print.printA()), "AAA").start();
        new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> print.printB()), "BBB").start();
        new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> print.printC()), "CCC").start();
        TimeUnit.SECONDS.sleep(1);
    }

    @SneakyThrows
    private void printC() {
        lock.lock();
        try {
            while (num != 3) {
                c3.await();
            }
            log.info("C");
            num = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    private void printB() {
        lock.lock();
        try {
            while (num != 2) {
                c2.await();
            }
            log.info("B");
            num = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    private void printA() {
        lock.lock();
        try {
            while (num != 1) {
                c1.await();
            }
            log.info("A");
            num = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    private void printABC(int targetNum, Condition currentThread, Condition nextThread) {
        for (int i = 0; i < 10; ) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {
                    currentThread.await(); // 阻塞当前线程
                }
                num++;
                i++;
                log.info(Thread.currentThread().getName());
                nextThread.signal();
                // 唤醒下一个线程，而不是唤醒所有线程
            } finally {
                lock.unlock();
            }
        }
    }

    @SneakyThrows
    @Test
    public void testV0() {
        ABCLockCondition print = new ABCLockCondition();
        new Thread(() -> print.printABC(0, c1, c2), "A").start();
        new Thread(() -> print.printABC(1, c2, c3), "B").start();
        new Thread(() -> print.printABC(2, c3, c1), "C").start();
        TimeUnit.SECONDS.sleep(1);
    }
}
