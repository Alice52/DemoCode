package cn.edu.ntu.javase.thread.create;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

/**
 * {@link Runnable } and {@link java.util.concurrent.FutureTask} can get thread result.
 *
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class RunnableCreate {

  @SneakyThrows
  public static void main(String[] args) {
    log.info("main method start ...");
    Thread cThread = new Thread(new CRunnable());
    cThread.start();
    log.info("main method end ...");

    log.info("main method start 2...");
    Integer i=0 ;
    FutureTask<Integer> futureTask = new FutureTask<>(cThread, i);
    new Thread(futureTask).start();
    Integer integer = futureTask.get();
    log.info("main method end 2...");
  }

  public static class CRunnable implements Runnable {
    @Override
    public void run() {
      log.info("thread-id: {}", Thread.currentThread().getId());
      int i = 10 / 2;
      log.info("logic result: {}", i);
    }
  }
}
