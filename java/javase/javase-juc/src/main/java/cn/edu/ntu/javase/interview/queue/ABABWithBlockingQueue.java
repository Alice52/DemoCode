package cn.edu.ntu.javase.interview.queue;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zack <br>
 * @create 2021-03-01 17:45 <br>
 * @project javase <br>
 */
@Slf4j
public class ABABWithBlockingQueue {

  @SneakyThrows
  public static void main(String[] args) {

    ResourceWithBlockingQueue r = new ResourceWithBlockingQueue(new ArrayBlockingQueue<>(3));

    new Thread(() -> r.produce(), "AA").start();
    new Thread(() -> r.produce(), "AA1").start();
    new Thread(() -> r.produce(), "AA2").start();
    new Thread(() -> r.consume(), "BB").start();

    TimeUnit.SECONDS.sleep(5);
    r.stop();
  }
}

@Slf4j
class ResourceWithBlockingQueue {
  /** 是否进行生产消费 */
  private volatile boolean flag = true;

  private AtomicInteger number = new AtomicInteger(0);
  private BlockingQueue<Integer> bq;

  public ResourceWithBlockingQueue(BlockingQueue<Integer> bq) {
    this.bq = bq;
    log.info("blocking queue type: {}", bq.getClass().getName());
  }

  @SneakyThrows
  public void produce() {
    boolean success;
    int i;
    for (; flag; ) { // 这个版本有可能 number 不连续
      // for (; flag && (bq.remainingCapacity() > 0 || bq instanceof SynchronousQueue); ) { //
      // number 是连续的
      i = number.incrementAndGet();
      success = bq.offer(i, 2, TimeUnit.SECONDS);
      if (success) {
        log.info("produce number: {}", i);
      } else {
        log.info("produce number failed: {}", i);
      }
    }

    log.info("produce stopped.");
  }

  @SneakyThrows
  public void consume() {
    Integer integer;
    for (; ; ) {
      integer = bq.poll(2, TimeUnit.SECONDS);
      if (integer == null) {
        log.info("consume stopped.");
        return;
      }
      log.info("consume number: {}", integer);

      TimeUnit.NANOSECONDS.sleep(10);
    }
  }

  /** 停止生产消费 */
  public void stop() {
    flag = false;
  }
}
