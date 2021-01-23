package cn.edu.ntu.javase.interview.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * use {@link java.util.concurrent.atomic.AtomicStampedReference } to fix ABA issue.
 *
 * @author zack <br>
 * @create 2021-01-20<br>
 * @project javase <br>
 */
@Slf4j
public class ABATest {

  static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

  public static void main(String[] args) {

    new Thread(
            () -> {
              atomicReference.compareAndSet(100, 101);
              atomicReference.compareAndSet(101, 100);
            },
            "AAA")
        .start();

    new Thread(
            () -> {
              try {
                // 保证AAA线程完成一次ABA操作
                TimeUnit.SECONDS.sleep(1);
                atomicReference.compareAndSet(100, 102);
              } catch (InterruptedException e) {
              }
            },
            "BBB")
        .start();

    // 等待 AAA, BBB 线程执行结束
    while (Thread.activeCount() > 2) {
      Thread.yield();
    }
    log.info("main thread atomicReference value: {}", atomicReference.get());
  }
}
