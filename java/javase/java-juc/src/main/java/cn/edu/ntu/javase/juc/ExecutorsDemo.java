package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zack
 * @create 2019-12-08 20:34
 * @function the object got by new can use pool to get
 */
public class ExecutorsDemo {

  private static final Logger LOG = LoggerFactory.getLogger(ExecutorsDemo.class);

  public static void main(String[] args) {
    executorPool();
    scheduledExecutorPool();
  }

  private static void scheduledExecutorPool() {
    Future<Integer> result;
    int poolSize = 5;
    ScheduledExecutorService executor =
        Executors.newScheduledThreadPool(poolSize); // specify number thread in pool
    ScheduledExecutorService singleExecutor =
        Executors.newSingleThreadScheduledExecutor(); // 1 thread in pool

    try {
      for (int i = 0; i < poolSize * 3; i++) {
        result =
            executor.schedule(
                () -> {
                  LOG.info(Thread.currentThread().getName());
                  return new Random().nextInt(10);
                },
                5,
                TimeUnit.SECONDS);
        LOG.info(Thread.currentThread().getName() + " result: " + result.get());
      }
    } catch (Exception e) {

    } finally {
      executor.shutdown();
    }
  }

  private static void executorPool() {
    Future<Integer> result;
    int poolSize = 5;
    ExecutorService executor =
        Executors.newFixedThreadPool(poolSize); // specify number thread in pool
    ExecutorService singleExecutor = Executors.newSingleThreadExecutor(); // 1 thread in pool
    ExecutorService nExecutor = Executors.newCachedThreadPool(); // N thread in pool

    try {
      for (int i = 0; i < poolSize * 3; i++) {
        result =
            executor.submit(
                () -> {
                  LOG.info(Thread.currentThread().getName());
                  return new Random().nextInt(10);
                });
        LOG.info(Thread.currentThread().getName() + " result: " + result.get());
      }
    } catch (Exception e) {

    } finally {
      executor.shutdown();
    }
  }
}
