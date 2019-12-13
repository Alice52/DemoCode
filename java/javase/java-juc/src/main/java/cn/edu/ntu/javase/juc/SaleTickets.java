package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zack
 * @create 2019-12-04 20:50
 * @function 3 seller sale 30 tickets with juc.
 *  1. thread -- operation -- resources
 *  2. high cohesion -- low coupling
 */
public class SaleTickets {

  public static void main(String[] args) {
    Ticket tickets = new Ticket();

    new Thread(
            () -> {
              for (int i = 1; i < 400; i++) {
                tickets.sale();
              }
            },
            "seller01")
        .start();
    new Thread(
            () -> {
              for (int i = 1; i < 400; i++) {
                tickets.sale();
              }
            },
            "seller02")
        .start();
    new Thread(
            () -> {
              for (int i = 1; i < 400; i++) {
                tickets.sale();
              }
            },
            "seller03")
        .start();
  }
}

// resources = instance var + instance method
class Ticket {

  private static final Logger LOG = LoggerFactory.getLogger(Ticket.class);

  private int number = 300;
  private Lock lock = new ReentrantLock();

  public synchronized void sale() {
    lock.lock();
    try {

      if (number > 0) {
        LOG.info(
            Thread.currentThread().getName()
                + " sale ticket number: "
                + number--
                + " ,"
                + number
                + " tickets left.");
      }

    } catch (Exception e) {

    } finally {
      lock.unlock();
    }
  }
}
