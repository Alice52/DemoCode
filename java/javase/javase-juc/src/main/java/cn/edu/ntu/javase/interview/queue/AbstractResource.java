package cn.edu.ntu.javase.interview.queue;

/**
 * @author zack <br>
 * @create 2021-03-01 18:15 <br>
 * @project javase <br>
 */
public abstract class AbstractResource {

  final int MAX_COUNT = 2;
  volatile int number = 0;

  public abstract void produce();

  public abstract void consume();
}
