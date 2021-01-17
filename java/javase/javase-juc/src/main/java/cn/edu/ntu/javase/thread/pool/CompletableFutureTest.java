package cn.edu.ntu.javase.thread.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 没有指定 Executor 的方法会使用 `ForkJoinPool.commonPool()` 作为它的线程池执行异步代码
 *
 * <pre>
 *     1. thenRun: 不能获取上一步的执行结果
 *     2. thenAcceptAsync: 能接受上一步结果, 但是无返回值
 *     3. thenApplyAsync: 能接受上一步结果, 有返回值
 *
 *     4. whenComplete/handle: 完成时回调, handle 可以指定异常时返回值
 *
 *     5. thenCombine/thenAcceptBoth/runAfterBoth
 *     6. applyToEither/acceptEither/runAfterEither
 *
 *     7. thenCompose: 把第一个返回值作为第二个参数
 *
 *     8. allOf: 所有结束
 *     9. anyOf: 有一个结束, 可以拿到返回值
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-17<br>
 * @project javase <br>
 */
@Slf4j
public class CompletableFutureTest {

  private static ThreadPoolExecutor executor =
      new ThreadPoolExecutor(
          5,
          200,
          10,
          TimeUnit.SECONDS,
          new LinkedBlockingDeque<>(10_0000),
          Executors.defaultThreadFactory(),
          new ThreadPoolExecutor.AbortPolicy());

  @SneakyThrows
  public static void main(String[] args) {
    log.info("main method start ...");

    // 1. runAsync: 异步执行没有返回值
    CompletableFuture<Void> runAsyncFuture =
        CompletableFuture.runAsync(
            () -> {
              log.info("runAsync thread-id: {}", Thread.currentThread().getId());
              int i = 10 / 2;
              log.info("runAsync logic result: {}", i);
            },
            executor);

    // 2. supplyAsync: 异步执行有返回值, get() 获取结果
    CompletableFuture<Integer> supplyAsyncFuture =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("supplyAsync thread-id: {}", Thread.currentThread().getId());
              int i = 10 / 2;
              log.info("supplyAsync logic result: {}", i);
              return i;
            },
            executor);

    // 3. 完成时回调: 只能感知异常, 但是没法修改返回值
    CompletableFuture<Integer> completableFuture =
        supplyAsyncFuture
            .whenCompleteAsync(
                (res, ex) -> {
                  log.info("result: {}; exception: {}", res, ex);
                })
            .exceptionally(ex -> 10);

    // 4. exceptionally 可以感知或异常, 和修改返回值

    log.info("main method end ...");
  }
}
