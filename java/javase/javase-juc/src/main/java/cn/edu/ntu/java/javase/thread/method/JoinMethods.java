package cn.edu.ntu.java.javase.thread.method;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * join 的意思是使得放弃当前线程的执行, 并返回对应的线程, 并执行调用 join 方法的线程
 *
 * <pre>
 *   1. join(long millis, int nanos): 在指定时间内执行调用 join 方法的线程, 且阻塞当前线程
 *   2. 在 main 函数中调用 <code>Thread.currentThread().join();</code> 会自己阻塞自己, 永远不会结束
 *       - 注意这里不是死锁, 线程状态是 WAITING
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-28<br>
 * @project javase <br>
 */
@Slf4j
public class JoinMethods {

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread =
                new Thread(
                        () -> {
                            log.info("running");
                            try {
                                TimeUnit.SECONDS.sleep(10);
                                log.info("finished");
                            } catch (InterruptedException e) {
                                log.info("{}", e);
                            }
                        },
                        "AAA");
        thread.start();
        // thread will execute first in specified time than main thread.
        // then after specified time, it will become normal
        thread.join(9_000, 10);

        Optional.of("All task finished.").ifPresent(System.out::println);

        Thread.currentThread().join();
    }
}
