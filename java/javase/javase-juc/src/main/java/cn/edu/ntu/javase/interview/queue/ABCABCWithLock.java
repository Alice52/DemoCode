package cn.edu.ntu.javase.interview.queue;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-03-01 19:17 <br>
 * @project javase <br>
 */
@Slf4j
public class ABCABCWithLock {

  public static void main(String[] args) {

    testResourceWithMoreCondition();
    // testShareResourceWith1Condition();
  }

  /** A B C 顺序执行10次 */
  public static void testShareResourceWith1Condition() {
    ShareResourceWith1Condition data = new ShareResourceWith1Condition();
    new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> data.executeA(i)), "AAA").start();
    new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> data.executeB(i)), "BBB").start();
    new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> data.executeC(i)), "CCC").start();
  }

  /** A B C 顺序执行10次 */
  public static void testResourceWithMoreCondition() {
    ResourceWithMoreCondition resource = new ResourceWithMoreCondition();
    new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> resource.print5()), "AAA").start();
    new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> resource.print10()), "BBB").start();
    new Thread(() -> IntStream.rangeClosed(0, 9).forEach(i -> resource.print15()), "CCC").start();
  }
}

@Slf4j
class ResourceWithMoreCondition {

  /** 1 - A; 2 - B; 3 - C; */
  volatile int flag = 1;

  private Lock lock = new ReentrantLock();
  private Condition conditionA = lock.newCondition();
  private Condition conditionB = lock.newCondition();
  private Condition conditionC = lock.newCondition();

  @SneakyThrows
  public void print5() {
    lock.lock();
    try {
      while (flag != 1) {
        conditionA.await();
      }

      IntStream.rangeClosed(1, 5).forEach(i -> log.info("{}", i));
      flag = 2;
      conditionB.signal();
    } finally {
      lock.unlock();
    }
  }

  @SneakyThrows
  public void print10() {
    lock.lock();
    try {
      while (flag != 2) {
        conditionB.await();
      }

      IntStream.rangeClosed(1, 10).forEach(i -> log.info("{}", i));
      flag = 3;
      conditionC.signal();
    } finally {
      lock.unlock();
    }
  }

  @SneakyThrows
  public void print15() {
    lock.lock();
    try {
      while (flag != 3) {
        conditionC.await();
      }

      IntStream.rangeClosed(1, 15).forEach(i -> log.info("{}", i));
      flag = 1;
      conditionA.signal();
    } finally {
      lock.unlock();
    }
  }
}

/**
 * 这里如果值使用一个 Condition, 也可以实现
 *
 * <pre>
 *     1. 如果使用 signal 会导致死锁问题:
 *        - 一共有三个线程, 若此时 flag = 1,
 *        - B 抢到执行权则 B await; C 抢到 C await
 *        - 之后 A 抢到 A 执行, flag = 2 可能唤醒的是 C[都是 一个 condition 的await], C wait,
 *        - A 又抢到, 此时所有人都 await, 所以死锁了
 *    2. 所以要是有 signalAll, 则三个线程都唤醒, 让他们去抢
 *        - flag = 1, C 抢到 await, B 抢到 await, 最后 A 抢到执行, 执行后唤醒所有的线程ABC
 *        - 继续步骤1
 * </pre>
 */
@Deprecated
@Slf4j
class ShareResourceWith1Condition {
  /** flag: A-1; B-2; C-3; */
  private int flag = 1;

  private Lock lock = new ReentrantLock();
  private Condition conditionA = lock.newCondition();

  @SneakyThrows
  public void executeA(int loopTimes) {
    lock.lock();
    try {
      while (flag != 1) {
        log.info("  executeA ");
        conditionA.await();
      }
      log.info("executeA " + loopTimes + " times");
      flag = 2;
      conditionA.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @SneakyThrows
  public void executeB(int loopTimes) {
    lock.lock();
    try {
      while (flag != 2) {
        log.info("  executeB ");
        conditionA.await();
      }
      log.info(" executeB " + loopTimes + " times");
      flag = 3;
      conditionA.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @SneakyThrows
  public void executeC(int loopTimes) {
    lock.lock();
    try {
      while (flag != 3) {
        log.info("  executeC ");
        conditionA.await();
      }
      log.info("executeC " + loopTimes + " times");
      flag = 1;
      conditionA.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
