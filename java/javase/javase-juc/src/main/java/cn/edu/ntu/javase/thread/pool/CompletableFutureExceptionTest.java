package cn.edu.ntu.javase.thread.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zack <br>
 * @create 2021-01-17<br>
 * @project javase <br>
 */
@Slf4j
public class CompletableFutureExceptionTest {

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

    AtomicBoolean isFailed = new AtomicBoolean(false);

    CompletableFuture<Void> runAsync =
        CompletableFuture.runAsync(
            () -> {
              log.info("thread 1 run async start ... ");
              throw new RuntimeException("thread-1");
            });

    CompletableFuture<RuntimeException> supplyAsync =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("thread 2 supply async start ... ");
              return new RuntimeException("thread-2");
            });

    CompletableFuture.allOf(runAsync, supplyAsync)
        .exceptionally(
            ex -> {
              log.info("ex: {}", ex);

              isFailed.set(true);
              return null;
            });

    if (isFailed.get()) {
      throw new RuntimeException();
    }

    // do logic
    log.info("do combined logic");

    log.info("main method end ...");
  }

  @SneakyThrows
  @Test
  public void checkAsync() {

    CompletableFuture<RuntimeException> supplyAsync =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("thread 2 supply async start ... ");
              return new RuntimeException("thread-2");
            });
    Optional.ofNullable(supplyAsync.get())
        .ifPresent(
            x -> {
              throw x;
            });
  }

  @SneakyThrows
  @Test
  public void checkAsyncAllof() {

    CompletableFuture<Void> runAsync =
        CompletableFuture.runAsync(
            () -> {
              log.info("thread 2 supply async start ... ");
              throw new RuntimeException("thread-2");
            });

    try {
      CompletableFuture.allOf(runAsync).join();
    } catch (CompletionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      }
      throw new RuntimeException(e.getCause().getMessage());
    }
  }


    @SneakyThrows
    @Test
    public void checkAsync2() {

        CompletableFuture<Void> runAsync =
                CompletableFuture.runAsync(
                        () -> {
                            log.info("thread 2 supply async start ... ");
                            throw new RuntimeException("thread-2");
                        });
        runAsync.get();
    }
}
