package cn.edu.ntu.javase.interview.abc.v2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author asd <br>
 * @create 2021-12-08 3:35 PM <br>
 * @project javase <br>
 */
@Slf4j
public class ABCWaitNotify {
    private static final Object LOCK = new Object();
    private int num;

    @SneakyThrows
    private void printABC(int targetNum) {
        synchronized (LOCK) {
            // 想想这里为什么不能用if代替while，想不起来可以看公众号上一篇文章
            while (num % 3 != targetNum) {
                LOCK.wait();
            }
            num++;
            log.info(Thread.currentThread().getName());
            LOCK.notifyAll();
        }
    }

    @SneakyThrows
    @Test
    public void testAbc() {
        ABCWaitNotify wait_notify_acb = new ABCWaitNotify();
        new Thread(() -> wait_notify_acb.printABC(0), "A").start();
        new Thread(() -> wait_notify_acb.printABC(1), "B").start();
        new Thread(() -> wait_notify_acb.printABC(2), "C").start();
        TimeUnit.SECONDS.sleep(2);
    }

    @SneakyThrows
    private void printABC10(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                // 想想这里为什么不能用if代替while，想不起来可以看公众号上一篇文章
                while (num % 3 != targetNum) {
                    LOCK.wait();
                }
                num++;
                log.info(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

    @SneakyThrows
    @Test
    public void testAbc10() {
        ABCWaitNotify wait_notify_acb = new ABCWaitNotify();
        new Thread(() -> wait_notify_acb.printABC10(0), "A").start();
        new Thread(() -> wait_notify_acb.printABC10(1), "B").start();
        new Thread(() -> wait_notify_acb.printABC10(2), "C").start();
        TimeUnit.SECONDS.sleep(2);
    }
}
