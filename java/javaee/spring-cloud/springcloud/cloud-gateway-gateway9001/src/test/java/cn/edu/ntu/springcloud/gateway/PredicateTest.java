package cn.edu.ntu.springcloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author zack <br>
 * @create 2020-04-09 21:11 <br>
 */
@Slf4j
public class PredicateTest {

    @Test
    public void testPredicateAfter() {
        log.info(String.valueOf(ZonedDateTime.now()));
    }
}
