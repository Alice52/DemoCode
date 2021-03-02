package cn.edu.ntu.javase.jvm.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;

/**
 * 内存足够的时候不 GC, 内存不够的时候会被回收
 *
 * @author zack <br>
 * @create 2021-03-02 15:20 <br>
 * @project javase <br>
 */
@Slf4j
public class SoftRefer {

  public static void main(String[] args) {
    testMemoryEnough();
    testMemoryOutMemory();
  }

  /** -XX:+PrintGCDetails -Xmx10m -Xms10m */
  public static void testMemoryOutMemory() {
    Object o = new Object();
    SoftReference<Object> softReference = new SoftReference<>(o);
    o = null;

    try {
      byte[] b = new byte[50 * 1024 * 1024];
    } finally {
      // null
      log.info("o: {}", o);
      // softReference 对象存在, 但是值是 null
      log.info("softReference: {}", softReference.get());
    }
  }

  public static void testMemoryEnough() {
    Object o = new Object();
    SoftReference<Object> softReference = new SoftReference<>(o);
    o = null;

    // null
    log.info("o: {}", o);
    // java.lang.ref.SoftReference@5010be6
    log.info("softReference: {}", softReference.get());
  }
}
