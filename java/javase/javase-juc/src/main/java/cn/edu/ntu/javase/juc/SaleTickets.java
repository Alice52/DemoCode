package cn.edu.ntu.javase.juc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 3 seller sale 30 tickets with juc. <br>
 *
 * <pre>
 *   1. thread -- operation -- resources
 *   2. high cohesion -- low coupling
 *   3. resources = instance var + instance method
 * </pre>
 *
 * @author zack
 * @create 2019-12-04 20:50
 */
public class SaleTickets {
  private static final int NUMBER = 500;

  public static void main(String[] args) {
    Ticket tickets = new Ticket();
    tickets.setNumber(NUMBER);

    new Thread(() -> IntStream.rangeClosed(1, NUMBER * 2).forEach(i -> tickets.sale()), "seller01")
        .start();
    new Thread(() -> IntStream.rangeClosed(1, NUMBER).forEach(i -> tickets.sale()), "seller02")
        .start();
  }
}

@Slf4j
@Data
class Ticket {
  private volatile int number = 3000;
  private Lock lock = new ReentrantLock();

  public void sale() {
    lock.lock();
    try {
      while (number > 0) {
        log.info("ale number {} ticket and {} left.", number--, number);
      }
    } finally {
      lock.unlock();
    }
  }
}
