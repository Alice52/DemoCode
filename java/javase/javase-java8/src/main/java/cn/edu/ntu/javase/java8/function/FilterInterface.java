package cn.edu.ntu.javase.java8.function;

/**
 * @author zack <br>
 * @create 2020-04-04 19:40 <br>
 */
@FunctionalInterface
public interface FilterInterface<T> {
    boolean condition(T t);
}
