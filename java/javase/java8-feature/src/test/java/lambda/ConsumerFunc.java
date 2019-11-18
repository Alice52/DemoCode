package lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author zack
 * @create 2019-11-18 20:44
 * @function
 */
public class ConsumerFunc {


    @Test
    public void testConsumer(){
        consume(s->System.out.println(s), new Object());
        consume(System.out::print, new Object());
    }

    public static <T> void consume(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
