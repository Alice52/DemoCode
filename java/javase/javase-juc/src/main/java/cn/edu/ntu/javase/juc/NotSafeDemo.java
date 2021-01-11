package cn.edu.ntu.javase.juc;

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
                System.out.println(
                    list); // write and read will occur ConcurrentModificationException
              })
          .start();
    }
    // can use CountDownLatch to await add finished
    TimeUnit.SECONDS.sleep(5);
    System.out.println(list); // []
  }

  public static void testSafedList() {
    List<String> list = new CopyOnWriteArrayList<>();

    for (int i = 0; i < 30; i++) {
      new Thread(
              () -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
              })
          .start();
    }

    System.out.println(list); // []
  }
}
