package cn.edu.ntu.javase.interview.obj;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-10-23 10:34 <br>
 * @project javase <br>
 */
@Slf4j
public class ObjectTests {

    // biasedLockingStartupDelay
    @SneakyThrows
    @Test
    public void testBiasedLock() {

        Object obj = new Object();
        log.info(ClassLayout.parseInstance(obj).toPrintable());

        TimeUnit.SECONDS.sleep(5);

        Object objWithBiasedLock = new Object();
        log.info(ClassLayout.parseInstance(objWithBiasedLock).toPrintable());
    }
}
