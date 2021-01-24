package cn.edu.ntu.javase.juc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Two threads alternately modify a variable: A-B-A-B
 *
 * <pre>
 *     1. synchronized 和 notify 是一组
 *     2. lock 和 condition 是一组
 *     3. synchronized 和 lock 不能混合使用, 否则会有线程安全问题
 * </pre>
 *
 * @author zack
 * @create 2019-12-04 21:46
 */
public class Abab {
  public static void main(String[] args) {

    ABABWithSynchronized withSynchronized = new ABABWithSynchronized();
    IntStream.rangeClosed(1, 5).forEach(i -> new Thread(() -> withSynchronized.increase()).start());
    IntStream.rangeClosed(1, 5).forEach(i -> new Thread(() -> withSynchronized.decrease()).start());

    ABABWithLock withLock = new ABABWithLock();
    IntStream.rangeClosed(1, 5).forEach(i -> new Thread(() -> withLock.increase()).start());
    IntStream.rangeClosed(1, 5).forEach(i -> new Thread(() -> withLock.decrease()).start());
  }
}

@Slf4j
class ABABWithSynchronized {
  private int number = 0;

  /** use if to do judge will lead to VirtualWake */
  @SneakyThrows
  public synchronized void increase() {
    while (number != 0) {
      this.wait();
    }
    ++number;
    log.info("increase number: {}", number);
    this.notifyAll();
  }

  @SneakyThrows
  public synchronized void decrease() {
    while (number != 1) {
      this.wait();
    }
    --number;
    log.info("decrease number: {}", number);
    this.notifyAll();
  }
}

@Slf4j
class ABABWithLock {
  private int number = 0;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  @SneakyThrows
  public void increase() {
    lock.lock();
    try {
      while (number != 0) {
        condition.await();
      }
      ++number;
      log.info("increase number: {}", number);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @SneakyThrows
  public void decrease() {
    lock.lock();
    try {
      while (number != 1) {
        condition.await();
      }
      --number;
      log.info("decrease number: {}", number);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
