package top.hubby.juc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 子线程常见的异常处理方式:
 *
 * <pre>
 *   1. 手动 try..catch
 *   2. UncaughtExceptionHandler: 不配置的话也会 log 出异常
 *        - 处理异常的顺序:
 *            + 当前线程有异常处理器
 *            + 当前线程所属的线程组有异常处理器
 *            + 全局默认的DefaultUncaughtExceptionHandler
 *            + 子线程就直接退出: 此时会出现逻辑没有执行, 且没有捕获异常的 log
 *        - Thread.setUncaughtExceptionHandler 设置当前线程的异常处理器
 *        - Thread.setDefaultUncaughtExceptionHandler 为整个程序设置默认的异常处理器
 *    3. Future 的 get/join 可以吧异常直接抛出来
 * </pre>
 *
 * @author zack <br>
 * @create 2021-06-01 09:29 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class SubThreadExceptionTest {

    @Test
    public void testTryCatch() {
        new Thread(new top.hubby.juc.ChildThread4TryCatch()).start();
        // 如果执行验证逻辑之后还没有停止, 可以手动停止主线程
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

    @Test
    public void testUncaughtExceptionHandler() {
        new Thread(new top.hubby.juc.ChildThread4UncaughtExceptionHandler()).start();
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

    @Test
    public void testUncaughtExceptionHandlerDefault() {
        new Thread(new top.hubby.juc.ChildThread4UncaughtExceptionHandlerDefault()).start();
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

    @Test
    public void testFuture() {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future future = executorService.submit(new top.hubby.juc.ChildThread4Future());
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            log.info(String.format("handle exception in child thread. %s", e));
        } finally {
            executorService.shutdown();
        }
    }

    /**
     * 这个子线程的异常会被忽略且不能被捕获
     *
     * <pre>
     *    1. 以下是 ForkJoinTaskPool 的 AsyncRun 的核心代码:
     *      - 他把异常直接 catch 了, 导致外层不能再次捕获, 只能从 exceptionally中获取异常
     *    2. code
     *    <code>
     *       static final class AsyncRun extends ForkJoinTask<Void>
     *           implements Runnable, AsynchronousCompletionTask {
     *              public void run() {
     *                      ...
     *                          try {
     *                              f.run();
     *                              d.completeNull();
     *                           } catch (Throwable ex) {
     *                               d.completeThrowable(ex);
     *                           }
     *                       ...
     *                   }
     *               }
     *           }
     *    </code>
     * </pre>
     */
    @SneakyThrows
    @Test
    public void testCompletableFuture() {

        CompletableFuture.runAsync(() -> exceptionMethod());
        TimeUnit.SECONDS.sleep(10);
    }

    private void exceptionMethod() {
        log.info("execute exceptionMethod ...");
        throw new RuntimeException("completable-future exception");
    }
}
