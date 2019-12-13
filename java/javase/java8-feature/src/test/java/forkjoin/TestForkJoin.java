package forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * @author zack
 * @create 2019-11-21 22:31
 * @function test ForkJoin two implement
 */
public class TestForkJoin {

  @Test
  public void testAction() {

    ForkJoinPool pool = new ForkJoinPool();
    Action action = new Action(1, 100000);
    pool.invoke(action);

    System.out.println(Action.AccumulatorHelper.getResult());
  }

  @Test
  // Recommend
  public void testTask() {

    ForkJoinPool pool = new ForkJoinPool();
    Task task = new Task(1, 100000);
    Long result = pool.invoke(task);

    System.out.println(result);
  }

  @Test
  public void testSequence() {
    // This will not exec step by step, it will be parallel[last tag]
    IntStream.rangeClosed(1, 1000)
        .parallel()
        .filter(null)
        .sequential()
        .map(null)
        .parallel()
        .forEach(null);
  }
}
