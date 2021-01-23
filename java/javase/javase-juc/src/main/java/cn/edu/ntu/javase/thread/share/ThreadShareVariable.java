package cn.edu.ntu.javase.thread.share;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class ThreadShareVariable {

  public static void main(String[] args) {
    new AppleThread("0001").start();
    new AppleThread("0002").start();
  }

  @NoArgsConstructor
  public static class AppleThread extends Thread {
    // 同类的多个线程共享同一块内存空间和一组系统资源
    private static int i;

    public AppleThread(String name) {
      super(name);
    }

    @Override
    public void run() {
      for (; i <= 1000; i++) {
        log.info("{}: {}", Thread.currentThread().getName(), i);
      }
    }
  }
}
