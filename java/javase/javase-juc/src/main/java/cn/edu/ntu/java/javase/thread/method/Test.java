package cn.edu.ntu.java.javase.thread.method;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.MAX_PRIORITY;

/**
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        // new JoinSleepThread().start();
        // new Thread(new YieldThread()).start();
        // testInterrupt();
        // interruptThread();
        // testJoin();
        // testSleep();
        testPriority();
    }

    /**
     * 设置优先级, 但是不一定准, 所以不用
     */
    private static void testPriority() {
        Thread priority = new JoinSleepThread();
        priority.start();

        priority.setPriority(MAX_PRIORITY);
        for (int i = 0; i < 10; i++) {
            log.info("{}: {}", Thread.currentThread().getName(), i);
        }

        log.info("priority thread: {}", priority.getPriority());
        log.info("main: {}", Thread.currentThread().getPriority());
    }

    /**
     * 告诉操作系统: 在未来的多少毫秒内不参与 CPU 竞争
     *
     * <pre>
     *    1. Thread.Sleep(0)的作用: 触发操作系统立刻重新进行一次CPU竞争
     *    2. 这也是我们在大循环里面经常会写一句Thread.Sleep(0), 因为这样就给了其他线程比如Paint线程获得CPU控制权的权力, 这样界面就不会假死在那里
     * </pre>
     */
    public static void testSleep() {
        Thread thread = new JoinSleepThread();
        thread.start();
        for (int i = 0; i < 100; i++) {
            log.info("main - {}: {}", Thread.currentThread().getName(), i);
        }
    }

    /**
     * 作用就是同步, 它可以使得线程之间的并行执行变为串行执行, 本质为: wait <br>
     *
     * <pre>
     *    1. join 的意思是使得放弃当前线程的执行, 并返回对应的线程, 并执行调用 join 的线程
     *    2. 在 A 线程中调用了 B 线程的 join() 方法时, 表示只有当 B 线程执行完毕时, A 线程才能继续执行
     *        - A 线程中调用了 B 线程的 join 方法, 则相当于 A 线程调用了 B 线程的 wait 方法, 在调用了 B 线程的 wait 方法后, A 线程就会进入阻塞状态
     *    3. join(10) 表示 main 线程会等待 t1 线程 10 毫秒, 10 毫秒过去后, main 线程和 t1 线程之间执行顺序由串行执行变为普通的并行执行
     *    4. join 方法可以在 start 方法前调用时, 并不能起到同步的作用
     * </pre>
     */
    public static void testJoin() {
        Thread thread = new JoinSleepThread();
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                try {
                    // main 执行的输出会被暂停, 等到 thread 执行完了 main 才有机会继续执行
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("main -- {}: {}", Thread.currentThread().getName(), i);
        }
    }

    /**
     * https://www.zhihu.com/question/41048032/answer/252905837
     *
     * <pre>
     *     1. 线程调用 interrupt() 时: 线程执行不收影响
     *        - 如果线程处于被阻塞状态[例如处于sleep, wait, join 等状态]，那么线程将立即退出被阻塞状态, 并抛出一个 {@link InterruptedException }, 仅此而已
     * 　　    - 如果线程处于正常活动状态, 那么会将该线程的中断标志设置为 true, 仅此而. 被设置中断标志的线程将继续正常运行， 不受影响
     * </pre>
     */
    @SneakyThrows
    private static void testInterrupt() {
        // 次线程, 主线程是 main[函数本身]
        Thread thread = new JoinSleepThread();
        // 判断线程是否活着: false
        log.info("before start: {}", thread.isAlive());
        thread.start();
        // true
        log.info("after start: {}", thread.isAlive());

        thread.interrupt();
        // true
        log.info("after interrupt: {}", thread.isAlive());

        thread.join();
        // false
        log.info("after join: {}", thread.isAlive());
        // 已经执行过的线程, 再次调用会出现异常, IllegalThreadStateException
        // thread.start();
    }

    /**
     * Real interrupt thread: interrupt 之后的代码还是会执行的
     *
     * <pre>
     *    1. interrupt() 并不能真正的中断线程, 需要被调用的线程自己进行配合才行. 中断线程:
     *        - 在正常运行任务时, 经常检查本线程的中断标志位, 如果被设置了中断标志就自行停止线程
     *        - 在调用阻塞方法时正确处理 {@link InterruptedException }, 例如, catch异常后就结束线程
     * </pre>
     */
    @SneakyThrows
    private static void interruptThread() {
        Thread thread =
                new Thread(
                        () -> {
                            while (!Thread.interrupted()) {
                                // 正常任务代码
                                log.info("{} interrupt.", Thread.currentThread().getName());
                            }
                            // 中断处理代码
                            // 可以在这里进行资源的释放等操作
                        });
        thread.start();
        TimeUnit.MICROSECONDS.sleep(1000);
        thread.interrupt();
    }

    /**
     * 在非 Main 函数中调用线程的 start 方法, 则 run 函数不会被执行<br>
     *
     * <pre>
     *     1. 可以调用 thread.run() 去运行线程
     *     2. 可以使用 sleep 使得 new 的线程有执行的时间
     * </pre>
     */
    @SneakyThrows
    @org.junit.Test
    public void testNoMainSleep() {
        Thread thread = new JoinSleepThread();
        thread.start();

        TimeUnit.SECONDS.sleep(3);
        // thread.run();
    }

    /**
     * 在 sleep 的时间内一定不会执行
     */
    public static class JoinSleepThread extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                if (i == 10) {
                    TimeUnit.SECONDS.sleep(5);
                }
                log.info("JoinSleepThread - {}: {}", Thread.currentThread().getName(), i);
            }
        }
    }

    /**
     * Test yield method: 下次还有可能时本线程
     *
     * <pre>
     *      1. 使当前线程从执行状态[运行状态]变为可执行态[就绪状态]
     *      2. cpu 会从众多的可执行态里选择, 所以还是可能选择执行当前线程
     *      3. yield 的本质是把当前线程重新置入抢 CPU 时间的队列
     *  </pre>
     */
    public static class YieldThread implements Runnable {
        // shared variable
        int i;

        @Override
        public void run() {
            for (; i < 100; i++) {
                if (i == 10) {
                    // 执行状态下的线程可以调用 yield 方法, 该方法用于主动出让 CPU 控制权.
                    Thread.yield();
                }

                // thread yield 之后这里还是会执行的
                log.info("{}: {}", Thread.currentThread().getName(), i);
            }
        }
    }
}
