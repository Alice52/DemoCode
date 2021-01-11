package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zack
 * @create 2019-12-04 21:46
 * @function Two threads alternately modify a variable
 */
public class NotifyWait {

  public static void main(String[] args) {

    NotifyWait notifyWait = new NotifyWait();
    notifyWait.NoVirtualWake();
    notifyWait.VirtualWake();
  }

  public void NoVirtualWake() {
    ShareDataVersion2 data = new ShareDataVersion2();
    increaseData(data, "increase-thread").start();
    decreaseData(data, "decrease-thread").start();
  }

  public void VirtualWake() {
    // handle with while to judge
    ShareDataVersion1 data = new ShareDataVersion1();
    increaseData(data, "increase-thread").start();
    increaseData(data, "increase-thread2").start();

    decreaseData(data, "decrease-thread").start();
    decreaseData(data, "decrease-thread2").start();
  }

  private Thread increaseData(ShareDataVersion2 data, String threadName) {
    return new Thread(
        () -> {
          for (int i = 0; i < 500; i++) {
            data.increase();
          }
        },
        threadName);
  }

  private Thread decreaseData(ShareDataVersion2 data, String threadName) {
    return new Thread(
        () -> {
          // Thread.sleep(200);
          for (int i = 0; i < 500; i++) {
            data.decrease();
          }
        },
        threadName);
  }

  private Thread increaseData(ShareDataVersion1 data, String threadName) {
    return new Thread(
        () -> {
          for (int i = 0; i < 500; i++) {
            data.increase();
          }
        },
        threadName);
  }

  private Thread decreaseData(ShareDataVersion1 data, String threadName) {
    return new Thread(
        () -> {
          // Thread.sleep(200);
          for (int i = 0; i < 500; i++) {
            data.decrease();
          }
        },
        threadName);
  }
}

class ShareDataVersion1 {
  private static final Logger LOG = LoggerFactory.getLogger(ShareDataVersion1.class);
  private int number = 0;

  public synchronized void increase() {
    try {
      // 2.1 judge
      //      if (number != 0) {
      while (number != 0) {
        this.wait();
      }
      // 2.2 work
      ++number;
      LOG.info(
          Thread.currentThread().getName() + " increase shareData finished, number: " + number);
      // 2.3 notify
      this.notifyAll();
    } catch (Exception e) {
      LOG.error("increase failed");
    }
  }

  public synchronized void decrease() {
    try {
      // 2.1 judge
      //      if (number != 1) {
      while (number != 1) {
        this.wait();
      }
      // 2.2 work
      --number;
      LOG.info(
          Thread.currentThread().getName() + " decrease shareData finished, number: " + number);
      // 2.3 notify
      this.notifyAll();
    } catch (Exception e) {
      LOG.error("increase failed");
    }
  }
}

class ShareDataVersion2 {
  private static final Logger LOG = LoggerFactory.getLogger(ShareDataVersion1.class);
  private int number = 0;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void increase() {
    lock.lock();
    try {
      while (number != 0) {
        condition.wait();
      }
      ++number;
      LOG.info(
          Thread.currentThread().getName() + " increase shareData finished, number: " + number);
      this.notifyAll();
    } catch (Exception e) {
      LOG.error("increase failed");
    } finally {
      lock.unlock();
    }
  }

  public void decrease() {
    lock.lock();
    try {
      while (number != 1) {
        this.wait();
      }
      --number;
      LOG.info(
          Thread.currentThread().getName() + " decrease shareData finished, number: " + number);
      // 2.3 notify
      condition.signalAll();
    } catch (Exception e) {
      LOG.error("increase failed");
    } finally {
      lock.unlock();
    }
  }
}
