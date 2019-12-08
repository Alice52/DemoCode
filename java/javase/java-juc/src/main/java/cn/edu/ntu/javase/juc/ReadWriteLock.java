package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
  public static void main(String[] args) throws InterruptedException {
      CustomQueue customQueue = new CustomQueue();

      new Thread(() -> customQueue.writeObject("zack"), "WriteThread").start();

    // sleep to make write first, then read thread will not read null value
      TimeUnit.SECONDS.sleep(1);
    for (int i = 0; i < 100; i++) {
        new Thread(() -> customQueue.readObject(), "ReadThread" + i).start();
    }
  }
}

class CustomQueue {
    private static final Logger LOG = LoggerFactory.getLogger(CustomQueue.class);

    private Object object;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void writeObject(Object object) {
        readWriteLock.writeLock().lock();
        this.object = object;
        LOG.info(Thread.currentThread().getName() + " write "+ object.toString());
        readWriteLock.writeLock().unlock();
    }

    public void readObject() {
        readWriteLock.readLock().lock();
        LOG.info(Thread.currentThread().getName() + " read "+ this.object.toString());
        readWriteLock.readLock().unlock();
    }
}
