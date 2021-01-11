package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
  private static final Logger LOG = LoggerFactory.getLogger(CallableDemo.class);

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<Integer> future =
        new FutureTask<>(
            () -> {
              TimeUnit.SECONDS.sleep(4);
              return 200;
            });

    // call() will just execute one time, unless use many new FutureTask<>(new Callable() {});
    new Thread(future, "Callable Thread1 implement").start();
    new Thread(future, "Callable Thread2 implement").start();

    LOG.info(Thread.currentThread().getName() + ": Main Thread execute");

    Integer integer = future.get();
    LOG.info("Callable Thread response: " + integer);
  }
}

class RThread implements Runnable {
  @Override
  public void run() {}
}

class CThread implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    TimeUnit.SECONDS.sleep(4);
    return 200;
  }
}
