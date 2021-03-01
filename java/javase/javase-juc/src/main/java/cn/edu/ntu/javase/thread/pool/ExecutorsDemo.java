package cn.edu.ntu.javase.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/**
 * the object got by new can use pool to get
 *
 * @author zack
 * @create 2019-12-08 20:34
 */
@Slf4j
public class ExecutorsDemo {

  public static void main(String[] args) {
    executorPool();
    //    scheduledExecutorPool();
  }

  private static void scheduledExecutorPool() {
    Future<Integer> result;
    int poolSize = 5;
    // specify number thread in pool
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(poolSize);
    // 1 thread in pool
    ScheduledExecutorService singleExecutor = Executors.newSingleThreadScheduledExecutor();

    try {
      for (int i = 0; i < poolSize * 3; i++) {
        result =
            executor.schedule(
                () -> {
                  log.info(Thread.currentThread().getName());
                  return new Random().nextInt(10);
                },
                5,
                TimeUnit.SECONDS);
        log.info(Thread.currentThread().getName() + " result: " + result.get());
      }
    } catch (Exception e) {

    } finally {
      executor.shutdown();
    }
  }

  private static void executorPool() {
    /** 银行窗口数 */
    int poolSize = 5;
    // specify number thread in pool
    ExecutorService executor = Executors.newFixedThreadPool(poolSize);
    // 1 thread in pool
    ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
    // N thread in pool
    ExecutorService nExecutor = Executors.newCachedThreadPool();

    try {
      // 10 人银行办理业务
      for (int i = 0; i < 10; i++) {
        int finalI = i;
        executor.execute(() -> log.info("{} 办理业务在{}窗口", finalI, Thread.currentThread().getName()));
      }
    } finally {
      executor.shutdown();
    }
  }
}
