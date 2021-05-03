package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @author zack
 * @create 2019-12-08 19:09
 */
public class CountDownLatchDemo {
    private static final Logger LOG = LoggerFactory.getLogger(CountDownLatchDemo.class);

    public static void main(String[] args) throws InterruptedException {
        int count = 20;

        CountDownLatch cdl = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(
                            () -> {
                                LOG.info(Thread.currentThread().getName() + " leave room.");
                                cdl.countDown();
                            },
                            String.valueOf(i))
                    .start();
        }
        cdl.await();
        LOG.info("no person in room, can close door!");
    }

    public static void closeDoor(int count) {
        for (int i = 0; i < count; i++) {
            new Thread(
                            () -> LOG.info(Thread.currentThread().getName() + " leave room."),
                            String.valueOf(i))
                    .start();
        }
        LOG.info("no person in room, can close door!");
    }
}
