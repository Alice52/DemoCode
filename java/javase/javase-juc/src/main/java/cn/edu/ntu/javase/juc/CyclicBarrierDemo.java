package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zack
 * @create 2019-12-08 19:54
 */
public class CyclicBarrierDemo {

    private static final int NUMBER = 10;
    private static final Logger LOG = LoggerFactory.getLogger(CyclicBarrierDemo.class);

    public static void main(String[] args) {
        CyclicBarrier cb =
                new CyclicBarrier(NUMBER, () -> LOG.info("all things is ok, open barrier!"));

        for (int i = 0; i < NUMBER; i++) {
            final int times = i;
            new Thread(
                            () -> {
                                LOG.info(
                                        Thread.currentThread().getName()
                                                + " on condition, and will await for open barrier, and now have "
                                                + times
                                                + " in wait.");
                                try {
                                    cb.await();
                                } catch (InterruptedException | BrokenBarrierException e) {
                                    e.printStackTrace();
                                }
                            },
                            String.valueOf(i))
                    .start();
        }
    }
}
