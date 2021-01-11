package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zack
 * @create 2019-12-08 20:21
 * @function get access to park; Eat hot pot in order
 *     <p>1. first in first get 2. leaved then others in
 */
public class SemaphoreDemo {

  private static final int PARK_NUMBER = 5;
  private static final Logger LOG = LoggerFactory.getLogger(SemaphoreDemo.class);

  public static void main(String[] args) {

    // mockup park number
    Semaphore semaphore = new Semaphore(PARK_NUMBER);

    for (int i = 0; i < PARK_NUMBER * 2; i++) {
      new Thread(
              () -> {
                try {
                  semaphore.acquire();
                  LOG.info(Thread.currentThread().getName() + " get access to park");

                  TimeUnit.SECONDS.sleep(
                      new Random().nextInt(10)); // park random second, then leave
                  LOG.info(Thread.currentThread().getName() + " leave park");
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } finally {
                  semaphore.release();
                }
              },
              String.valueOf(i))
          .start();
    }
  }
}
