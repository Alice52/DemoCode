package cn.edu.ntu.java.javase.java8.function;

/**
 * @author zack <br>
 * @create 2020-04-04 19:39 <br>
 */
@FunctionalInterface
public interface CreateEmployee<T, U, W, R> {
    R sup(T t, U u, W w);
}
