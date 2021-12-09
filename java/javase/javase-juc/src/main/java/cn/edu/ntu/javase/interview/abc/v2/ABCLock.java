package cn.edu.ntu.javase.interview.abc.v2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author asd <br>
 * @create 2021-12-08 4:42 PM <br>
 * @project javase <br>
 */
@Slf4j
public class ABCLock {
    private int num;
    // 当前状态值：保证三个线程之间交替打印
    private Lock lock = new ReentrantLock();

    @SneakyThrows
    public static void main(String[] args) {
        ABCLock lockABC = new ABCLock();

        new Thread(() -> lockABC.printABC(0), "A").start();
        new Thread(() -> lockABC.printABC(1), "B").start();
        new Thread(() -> lockABC.printABC(2), "C").start();

        TimeUnit.SECONDS.sleep(1);
    }

    private void printABC(int targetNum) {
        int i = 0;
        while (i < 10) {
            lock.lock();
            if (num % 3 == targetNum) {
                num++;
                i++;
                log.info(Thread.currentThread().getName());
            }
            lock.unlock();
        }
    }

    private void printA(int targetNum) {
        while (true) {
            lock.lock();
            if (num >= 10) {
                break;
            }
            if (num % 3 == targetNum) {
                num++;
                log.info(Thread.currentThread().getName());
            }
            lock.unlock();
        }
    }
}
