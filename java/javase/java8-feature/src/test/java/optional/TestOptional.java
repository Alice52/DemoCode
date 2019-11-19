package optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author zack
 * @create 2019-11-19 21:16
 * @function
 */
public class TestOptional {


    @Test
    public void testCreateOptional() {
        Optional<Integer> empty = Optional.empty();

        Optional<Integer> of = Optional.of(new Integer(1));

        Optional<Integer> integer = Optional.ofNullable(20);
        Optional<Integer> o = Optional.ofNullable(null);
    }
}
