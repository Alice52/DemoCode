package cn.edu.ntu.javase.interview.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link ReentrantLock } 是可重入锁<br>
 * {@code synchronized } 是可重入锁<br>
 *
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
@Slf4j
public class ReenterLock {
  private static Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    testSynchronizedReentrant();
    //testReentrantLockReentrant();
  }

  private static void testReentrantLockReentrant() {

    new Thread(() -> m0(), "AAA").start();
    new Thread(() -> m1(), "BBB").start();
  }

  private static void testSynchronizedReentrant() {

    new Thread(() -> get(), "AAA").start();
    new Thread(() -> get(), "BBB").start();
  }

  private static synchronized void get() {
    log.info("thread: {} synchronized -- get", Thread.currentThread().getName());
    set();
  }

  private static synchronized void set() {
    log.info("thread: {} synchronized -- set", Thread.currentThread().getName());
  }

  /** Lock 只要成对出现就可以, 次数无关 */
  private static void m0() {
    lock.lock();
    lock.lock();
    try {
      log.info("thread: {} reentrant-lock -- m0", Thread.currentThread().getName());
      m1();
    } finally {
      lock.unlock();
      log.info("thread: {} reentrant-unlock -- m0", Thread.currentThread().getName());
      lock.unlock();
    }
  }

  private static void m1() {
    lock.lock();
    try {
      log.info("thread: {} reentrant-lock -- m1", Thread.currentThread().getName());
    } finally {
      lock.unlock();
      log.info("thread: {} reentrant-unlock -- m1", Thread.currentThread().getName());
    }
  }
}
