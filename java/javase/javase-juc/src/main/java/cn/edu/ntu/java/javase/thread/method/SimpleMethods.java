package cn.edu.ntu.java.javase.thread.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * simple method:
 *
 * <pre>
 *     1. getThreadGroup 获取组信息
 *     2. run 不会产生新的线程, 线程ID是调用者线程 ID
 *     3. start 方法只能调用一遍, 使用的时模板方法, runnable 是执行的策略
 *          - 模板方法: 指定一定的逻辑代码之后, 调用 native 方法 start0[调用 run 方法]
 *     4. enumerate 获取当前所有线程
 *     5. setDaemon: 设置为守护线程, 依附于非守护线程存在
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-26<br>
 * @project javase <br>
 */
@Slf4j
public class SimpleMethods {

    public static void main(String[] args) {
        Thread thread =
                new Thread(
                        () -> {
                            log.info("start");
                            try {
                                TimeUnit.SECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                log.info("error:{}", e);
                            }
                        },
                        "AAA");

        ThreadGroup group = thread.getThreadGroup();
        log.info("group: {}, main group: {}", group, Thread.currentThread().getThreadGroup());
        // thread.run();
        thread.setDaemon(true);
        thread.start();

        Thread[] allThreads = new Thread[Thread.activeCount()];
        Thread.enumerate(allThreads);
        Stream.of(allThreads).forEach(System.out::println);
    }
}
