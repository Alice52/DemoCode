package cn.edu.ntu.java.javase.syntax;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2021-04-13 22:25 <br>
 * @project javase <br>
 */
@Slf4j
public class MathTest {

    @Test
    public void testCeil(/*向上取整*/ ) {

        log.info("ceil(-1.1): {}", Math.ceil(-1.1));
        log.info("ceil(-1.5): {}", Math.ceil(-1.5));
        log.info("ceil(-1.8): {}", Math.ceil(-1.8));

        log.info("ceil(1.1): {}", Math.ceil(1.1));
        log.info("ceil(1.5): {}", Math.ceil(1.5));
        log.info("ceil(1.8): {}", Math.ceil(1.8));
    }

    @Test
    public void testRound(/*四舍五入*/ ) {

        log.info("round(-1.1): {}", Math.round(-1.1));
        log.info("round(-1.5): {}", Math.round(-1.5));
        log.info("round(-1.55): {}", Math.round(-1.55));
        log.info("round(-1.8): {}", Math.round(-1.8));

        log.info("round(1.1): {}", Math.round(1.1));
        log.info("round(1.5): {}", Math.round(1.5));
        log.info("round(1.8): {}", Math.round(1.8));
    }
}
