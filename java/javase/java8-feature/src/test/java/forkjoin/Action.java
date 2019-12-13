package forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zack
 * @create 2019-11-21 22:21
 * @function
 */
public class Action extends RecursiveAction {

  private long start;
  private long end;
  private static final long THRESHOLD = 10000000L;

  public Action() {}

  public Action(long start, long end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected void compute() {
    long length = end - start;

    if (length <= THRESHOLD) {
      for (long i = start; i <= end; i++) {
        AccumulatorHelper.accumulate(i);
      }
    } else {
      long middle = (start + end) / 2;
      Task forkJoinLeft = new Task(start, middle);
      forkJoinLeft.fork();
      Task forkJoinRight = new Task(middle + 1, end);
      forkJoinRight.fork();
    }
  }

  static class AccumulatorHelper {
    private static final AtomicLong RESULT = new AtomicLong(0L);

    static void accumulate(long value) {
      RESULT.getAndAdd(value);
    }

    public static long getResult() {
      return RESULT.get();
    }

    static void reset() {
      RESULT.set(0);
    }
  }
}
