package cn.edu.ntu.javase.java8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author zack <br>
 * @create 2020-04-04 21:33 <br>
 */
public class ConsumerFuncTest {
  @Test
  public void testConsumer() {
    consume(s -> System.out.println(s), "new Object()");
    consume(System.out::println, "new Object()");
  }

  public static <T> void consume(Consumer<T> consumer, T t) {
    consumer.accept(t);
  }
}
