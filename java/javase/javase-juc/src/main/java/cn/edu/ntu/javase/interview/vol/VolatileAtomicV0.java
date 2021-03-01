package cn.edu.ntu.javase.interview.vol;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-01-18<br>
 * @project javase <br>
 */
@Slf4j
public class VolatileAtomicV0 {

  static volatile int number = 0;
  static AtomicInteger atomicInteger = new AtomicInteger(0);

  /**
   * 50个线程执行 plus 方法 1k 次: 理论上 number 需要是 5w[证明原子性]
   *
   * @param args
   */
  public static void main(String[] args) {

      for (int i = 0; i < 50; i++) {
      new Thread(
              () ->
                  IntStream.rangeClosed(1, 1000)
                      .forEach(
                          x -> {
                            number++;
                            atomicInteger.addAndGet(1);
                          }))
          .start();
      }

    // 需要等待上面 50 个线程都执行完成后 在 main 线程中去 number
    while (Thread.activeCount() > 2) { // main + gc 两个线程
      Thread.yield(); // 放弃执行, 把当前线程重新置入抢 CPU 时间的队列
    }

    log.info(
        "thread: {} get number value is {}, atomic value: {}",
        Thread.currentThread().getName(),
        number,
        atomicInteger.get());
  }
}
