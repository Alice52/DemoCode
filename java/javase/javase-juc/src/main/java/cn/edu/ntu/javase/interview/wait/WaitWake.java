package cn.edu.ntu.javase.interview.wait;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zack <br>
 * @create 2021-03-01 23:37 <br>
 * @project javase <br>
 */
@Slf4j
public class WaitWake {

  public static void main(String[] args) {
    // waitWakeByThread();
    // waitWakeByLock();

    waitWakeByLockSupport();
  }

    /**
     * LockSupport 方法实现等待唤醒
     *
     * <pre>
     *    - LockSupport api 的方法
     *    - 先 unpark 之后 park 也是可以的
     *    - 可以不再同步代码块内执行
     * </pre>
     */
  @SneakyThrows
  public static void waitWakeByLockSupport() {

    Thread threadA =
        new Thread(
            () -> {
              log.info("come in");
              LockSupport.park();
              log.info("wake");
            },
            "AA");
    threadA.start();

    TimeUnit.SECONDS.sleep(2);

    new Thread(
            () -> {
              log.info(" to do notify");
              LockSupport.unpark(threadA);
            },
            "BB")
        .start();
  }

  /**
   * Lock 方法实现等待唤醒
   *
   * <pre>
   *    - Lock api 的方法
   *    - 也必须在 lock()/unlock() 的代码块内执行
   *    - signal 在 await 之前执行则不能唤醒: 先等待后唤醒
   *    - signal 可以精准唤醒
   * </pre>
   */
  public static void waitWakeByLock() {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    new Thread(
            () -> {
              lock.lock();
              try {
                log.info("come in");
                condition.await();
              } catch (InterruptedException e) {
                e.printStackTrace();
              } finally {

                lock.lock();
              }
              log.info("wake");
            },
            "AA")
        .start();

    new Thread(
            () -> {
              lock.lock();
              try {
                TimeUnit.SECONDS.sleep(2);
                log.info(" to do notify");
                condition.signal();
              } catch (InterruptedException e) {
                e.printStackTrace();
              } finally {
                lock.unlock();
              }
            },
            "BB")
        .start();
  }

  /**
   * Thread 方法实现等待唤醒
   *
   * <pre>
   *    - 是 Object 的方法
   *    - 必须在同步代码块内执行[依赖 monitor]
   *    - notify 在 wait 之前执行则不能唤醒: 先等待后唤醒
   *    - notify 执行随机唤醒一个线程
   * </pre>
   */
  public static void waitWakeByThread() {
    Object lock = new Object();

    new Thread(
            () -> {
              synchronized (lock) {
                try {
                  log.info("come in");
                  lock.wait();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                log.info("wake");
              }
            },
            "AA")
        .start();

    new Thread(
            () -> {
              synchronized (lock) {
                try {
                  TimeUnit.SECONDS.sleep(2);
                  log.info(" to do notify");
                  lock.notify();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "BB")
        .start();
  }
}
