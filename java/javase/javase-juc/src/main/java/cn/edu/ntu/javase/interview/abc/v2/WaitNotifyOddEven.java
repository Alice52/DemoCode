package cn.edu.ntu.javase.interview.abc.v2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author asd <br>
 * @create 2021-12-08 3:41 PM <br>
 * @project javase <br>
 */
@Slf4j
public class WaitNotifyOddEven {
    private Object lock = new Object();
    private volatile int count;

    @SneakyThrows
    private void printOddEvenV1(int threadId) {
        synchronized (lock) {
            while (count < 10) {
                while (count % 2 != threadId) {
                    lock.wait();
                }

                if (count >= 10) {
                    break;
                }
                System.out.print(Thread.currentThread().getName() + "：");
                System.out.println(++count);
                lock.notifyAll();
            }
            // 防止count=10后，while()循环不再执行，有子线程被阻塞未被唤醒，导致主线程不能退出
            lock.notifyAll();
        }
    }

    @SneakyThrows
    @Test
    public void testV1() {

        WaitNotifyOddEven waitNotifyOddEven = new WaitNotifyOddEven();
        new Thread(() -> waitNotifyOddEven.printOddEvenV1(0), "even").start();
        Thread.sleep(10); // 为了保证线程odd先拿到锁
        new Thread(() -> waitNotifyOddEven.printOddEvenV1(1), "odd").start();

        Thread.sleep(1010);
    }

    @SneakyThrows
    private void printOddEvenV0() {
        synchronized (lock) {
            while (count < 10) {
                System.out.print(Thread.currentThread().getName() + "：");
                System.out.println(++count);
                lock.notifyAll();
                lock.wait();
            }
            // 防止count=10后，while()循环不再执行，有子线程被阻塞未被唤醒，导致主线程不能退出
            lock.notifyAll();
        }
    }

    @SneakyThrows
    @Test
    public void testV0() {

        WaitNotifyOddEven waitNotifyOddEven = new WaitNotifyOddEven();
        new Thread(waitNotifyOddEven::printOddEvenV0, "odd").start();
        Thread.sleep(10); // 为了保证线程odd先拿到锁
        new Thread(waitNotifyOddEven::printOddEvenV0, "even").start();

        Thread.sleep(1010);
    }
}
