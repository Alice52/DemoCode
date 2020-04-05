package cn.edu.ntu.javase.java8;

import cn.edu.ntu.javase.java8.forkjoin.CustomAction;
import cn.edu.ntu.javase.java8.forkjoin.CustomTask;
import cn.edu.ntu.javase.java8.utils.AccumulatorHelper;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2020-04-04 21:24 <br>
 */
public class CustomForkJoinTest {

  @Test
  public void testAction() {

    ForkJoinPool pool = new ForkJoinPool();
    CustomAction action = new CustomAction(1, 100000);
    pool.invoke(action);

    System.out.println(AccumulatorHelper.getResult());
  }

  @Test
  // Recommend
  public void testTask() {

    ForkJoinPool pool = new ForkJoinPool();
    CustomTask task = new CustomTask(1, 100000);
    Long result = pool.invoke(task);

    System.out.println(result);
  }

  @Test
  public void testSequence() {
    // This will not exec step by step, it will be parallel[last tag]
    IntStream.rangeClosed(1, 1000)
        .parallel()
        .filter(x -> x > 15)
        .sequential()
        .map(x -> x)
        .parallel()
        .forEach(System.out::println);
  }
}
