package cn.edu.ntu.javase.interview.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zack <br>
 * @create 2021-01-20<br>
 * @project javase <br>
 */
@Slf4j
public class ABASolutionTest {
    static int initVersion = 1;
    static AtomicStampedReference<Integer> atomicReference =
            new AtomicStampedReference<>(100, initVersion);

    public static void main(String[] args) {

        new Thread(
                        () -> {
                            // 需要 sleep 一下, 使得 BBB 可以拿到最初的版本号
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                            }

                            int stamp = atomicReference.getStamp();
                            log.info(
                                    "thread name: {}, version: {}",
                                    Thread.currentThread().getName(),
                                    stamp);
                            atomicReference.compareAndSet(100, 101, stamp, ++stamp);
                            log.info(
                                    "thread name: {}, version: {}",
                                    Thread.currentThread().getName(),
                                    atomicReference.getStamp());
                            atomicReference.compareAndSet(101, 100, stamp, ++stamp);
                            log.info(
                                    "thread name: {}, version: {}",
                                    Thread.currentThread().getName(),
                                    atomicReference.getStamp());
                        },
                        "AAA")
                .start();

        new Thread(
                        () -> {
                            try {
                                int stamp = atomicReference.getStamp();
                                log.info(
                                        "thread name: {}, version: {}",
                                        Thread.currentThread().getName(),
                                        stamp);

                                // 保证AAA线程完成一次ABA操作
                                TimeUnit.SECONDS.sleep(3);
                                boolean success =
                                        atomicReference.compareAndSet(100, 102, stamp, ++stamp);

                                log.info(
                                        "thread name: {}, change 100 to 102 success: {}, version: {}",
                                        Thread.currentThread().getName(),
                                        success,
                                        atomicReference.getStamp());

                            } catch (InterruptedException e) {
                            }
                        },
                        "BBB")
                .start();

        // 等待 AAA, BBB 线程执行结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        log.info(
                "main thread atomicReference version: {}, value: {}",
                atomicReference.getStamp(),
                atomicReference.getReference().intValue());
    }
}
