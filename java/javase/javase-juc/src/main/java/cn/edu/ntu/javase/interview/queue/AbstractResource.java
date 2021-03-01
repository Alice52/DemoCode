package cn.edu.ntu.javase.interview.queue;

/**
 * @author zack <br>
 * @create 2021-03-01 18:15 <br>
 * @project javase <br>
 */
public abstract class AbstractResource {

  volatile int number = 0;
  final int MAX_COUNT = 2;

  public abstract void produce();

  public abstract void consume();
}
