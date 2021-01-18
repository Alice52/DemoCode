package cn.edu.ntu.javase.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author zack
 * @create 2019-12-08 21:08
 * @function
 */
@Slf4j
public class NotSafeDemo {

  public static void main(String[] args) throws InterruptedException {
    testUnSafedList();
  }

  public static void testUnSafedList() throws InterruptedException {
    List<String> list = new ArrayList();

    for (int i = 0; i < 30; i++) {
      new Thread(
              () -> {
                list.add(UUID.randomUUID().toString());
                // write and read will occur ConcurrentModificationException
                log.info("{}", list);
              })
          .start();
    }
    // can use CountDownLatch to await add finished
    TimeUnit.SECONDS.sleep(5);
    // []
    System.out.println(list);
  }

  public static void testSafedList() {
    List<String> list = new CopyOnWriteArrayList<>();

    for (int i = 0; i < 30; i++) {
      new Thread(
              () -> {
                list.add(UUID.randomUUID().toString());
                log.info("{}", list);
              })
          .start();
    }

    // []
    log.info("{}", list);
  }
}
