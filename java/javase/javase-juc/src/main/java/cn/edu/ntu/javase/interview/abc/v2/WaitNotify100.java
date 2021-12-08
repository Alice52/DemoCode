package cn.edu.ntu.javase.interview.abc.v2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * N 个线程循环打印 1-m
 *
 * @author asd <br>
 * @create 2021-12-08 3:35 PM <br>
 * @project javase <br>
 */
@Slf4j
public class WaitNotify100 {
    private static final Object MONITOR = new Object();
    private volatile int m;
    private int mMax = 1000;
    private int n = 15;

    @SneakyThrows
    private void printNM(int threadId) {
        while (m < mMax) {
            synchronized (MONITOR) {
                // 此时 m=999, 且所有线程都执行到此处, 最后一个线程执行加1, 并把所有线程唤醒, 所以需要加下面的if校验
                while (m % n != threadId) {
                    MONITOR.wait();
                }

                if (m >= mMax) {
                    break;
                }

                m++;
                log.info(Thread.currentThread().getName() + ": " + m);
                MONITOR.notifyAll();
            }
        }
    }

    @SneakyThrows
    @Test
    public void testAbc10() {
        WaitNotify100 notify100 = new WaitNotify100();
        IntStream.range(0, n)
                .forEach(x -> new Thread(() -> notify100.printNM(x), "Thread-" + x).start());
        TimeUnit.SECONDS.sleep(2);
    }
}
