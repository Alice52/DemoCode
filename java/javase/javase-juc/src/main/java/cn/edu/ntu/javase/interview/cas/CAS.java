package cn.edu.ntu.javase.interview.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zack <br>
 * @create 2021-01-20<br>
 * @project javase <br>
 */
@Slf4j
public class CAS {
  public static void main(String[] args) {

    AtomicInteger atomicInteger = new AtomicInteger(5);
    atomicInteger.compareAndSet(5, 2019);
    log.info("now value is: {}", atomicInteger);

    boolean c = atomicInteger.compareAndSet(5, 2020);
    log.info("change success: {}, now value is: {}", c, atomicInteger);

    atomicInteger.getAndIncrement();
  }
}
