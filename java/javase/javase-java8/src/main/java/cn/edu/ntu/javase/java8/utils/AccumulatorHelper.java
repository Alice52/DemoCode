package cn.edu.ntu.javase.java8.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zack <br>
 * @create 2020-04-04 21:26 <br>
 */
public final class AccumulatorHelper {
  private static final AtomicLong RESULT = new AtomicLong(0L);

  public static void accumulate(long value) {
    RESULT.getAndAdd(value);
  }

  public static long getResult() {
    return RESULT.get();
  }

  public static void reset() {
    RESULT.set(0);
  }
}
