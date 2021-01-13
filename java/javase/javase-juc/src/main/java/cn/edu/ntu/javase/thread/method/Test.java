package cn.edu.ntu.javase.thread.method;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class Test {

  public static void main(String[] args) {
    new JoinSleepThread().start();
    new Thread(new YieldThread()).start();

    testInterrupt();
    interruptThread();
  }

  /**
   * https://www.zhihu.com/question/41048032/answer/252905837
   *
   * <pre>
   *     1. 线程调用 interrupt() 时: 线程执行不收影响
   *        - 如果线程处于被阻塞状态[例如处于sleep, wait, join 等状态]，那么线程将立即退出被阻塞状态, 并抛出一个 {@link InterruptedException }, 仅此而已
   * 　　    - 如果线程处于正常活动状态, 那么会将该线程的中断标志设置为 true, 仅此而. 被设置中断标志的线程将继续正常运行， 不受影响
   * </pre>
   */
  @SneakyThrows
  private static void testInterrupt() {
    // 次线程, 主线程是 main[函数本身]
    Thread thread = new JoinSleepThread();
    // 判断线程是否活着: false
    log.info("before start: {}", thread.isAlive());
    thread.start();
    // true
    log.info("after start: {}", thread.isAlive());

    thread.interrupt();
    // true
    log.info("after interrupt: {}", thread.isAlive());

    thread.join();
    // false
    log.info("after join: {}", thread.isAlive());
    // 已经执行过的线程, 再次调用会出现异常, IllegalThreadStateException
    // thread.start();
  }

  /**
   * Real interrupt thread: interrupt 之后的代码还是会执行的
   *
   * <pre>
   *    1. interrupt() 并不能真正的中断线程, 需要被调用的线程自己进行配合才行. 中断线程:
   *        - 在正常运行任务时, 经常检查本线程的中断标志位, 如果被设置了中断标志就自行停止线程
   *        - 在调用阻塞方法时正确处理 {@link InterruptedException }, 例如, catch异常后就结束线程
   * </pre>
   */
  @SneakyThrows
  private static void interruptThread() {
    Thread thread =
        new Thread(
            () -> {
              while (!Thread.interrupted()) {
                // 正常任务代码
                log.info("{} interrupt.", Thread.currentThread().getName());
              }
              // 中断处理代码
              // 可以在这里进行资源的释放等操作
            });
    thread.start();
    TimeUnit.MICROSECONDS.sleep(1000);
    thread.interrupt();
  }

  /** Test Sleep method: it will not surrender execution rights. */
  public static class JoinSleepThread extends Thread {
    @SneakyThrows
    @Override
    public void run() {
      for (int i = 0; i <= 100; i++) {
        if (i == 10) {
          TimeUnit.SECONDS.sleep(1000);
        }
        log.info("{}: {}", Thread.currentThread().getName(), i);
      }
    }
  }
  /**
   * Test Sleep method: it will surrender execution rights.
   *
   * <pre>
   *      1. 使当前线程从执行状态[运行状态]变为可执行态[就绪状态]
   *      2. cpu 会从众多的可执行态里选择, 所以还是可能选择执行当前线程
   *      3. yield 的本质是把当前线程重新置入抢 CPU 时间的队列
   *  </pre>
   */
  public static class YieldThread implements Runnable {
    // shared variable
    int i;

    @Override
    public void run() {
      for (; i < 100; i++) {
        if (i == 10) {
          // 执行状态下的线程可以调用 yield 方法, 该方法用于主动出让 CPU 控制权.
          Thread.yield();
        }

        log.info("{}: {}", Thread.currentThread().getName(), i);
      }
    }
  }
}
