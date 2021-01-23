package cn.edu.ntu.javase.interview.list;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
@Slf4j
public class UnsafeArrayList {

  public static void main(String[] args) {

    /**
     * explain of ArrayList:
     *
     * <pre>
     *     1. ArrayList 底层是空 Object 的数组: transient Object[] elementData;
     *     2. add 时会初始化容量为 10 的数组并添加元素: DEFAULT_CAPACITY = 10;
     *     3. 扩容时: elementData = Arrays.copyOf(elementData, newCapacity);
     * </pre>
     *
     * explain thread:
     *
     * <pre>
     *     1. 多线程操作 {@link ArrayList } 会出现 {@link java.util.ConcurrentModificationException}
     *     2. 线程不安全: add 方法没有加锁
     *     3. solution
     *          - {@link java.util.Vector}: add synchronized
     *          - {@link Collections#synchronizedList(List)}: synchronized (mutex) {list.add(index, element);}
     *          - {@link java.util.concurrent.CopyOnWriteArrayList }:  use {@code ReentrantLock volatile Object[] array;}
     * </pre>
     */
    List<String> unsafeList = new ArrayList<>();
    List<String> safeVector = new Vector<>();
    // unsafeList 也会有值
    List<String> safeList = Collections.synchronizedList(unsafeList);

    Assert.isFalse(unsafeList == safeList);

    IntStream.rangeClosed(1, 100)
        .forEach(
            i ->
                new Thread(
                        () -> {
                          String uuid = UUID.fastUUID().toString();
                          // unsafeList.add(uuid);
                          safeVector.add(uuid);
                          safeList.add(uuid);
                        },
                        "AAA" + i)
                    .start());

    while (Thread.activeCount() > 2) {
      Thread.yield();
    }

    log.info("unsafeList: {}", unsafeList);
    log.info("safeVector: {}", safeVector);
    log.info("safeList: {}", safeList);
  }

  public void arraysTest() {
    List<String> list = Arrays.asList("a", "b", "c");
    // list.add("a"); // java.lang.UnsupportedOperationException
    list.forEach(System.out::println);
  }
}
