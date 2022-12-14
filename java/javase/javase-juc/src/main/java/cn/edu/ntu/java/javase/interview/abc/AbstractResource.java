package cn.edu.ntu.java.javase.interview.abc;

/**
 * @author zack <br>
 * @create 2021-03-01 18:15 <br>
 * @project javase <br>
 */
public abstract class AbstractResource {

    final int MAX_COUNT = 1;
    volatile int number = 0;

    public abstract void produce();

    public abstract void consume();
}
