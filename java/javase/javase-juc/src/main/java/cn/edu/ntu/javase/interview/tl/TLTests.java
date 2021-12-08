package cn.edu.ntu.javase.interview.tl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-10-13<br>
 * @project javase <br>
 */
@Slf4j
public class TLTests {

    @Test
    public void testTLShare() {
        ThreadLocal<String> tl = new ThreadLocal<String>();

        new Thread(
                        () -> {
                            try {
                                TimeUnit.SECONDS.sleep(2);
                                log.info("ThreadLocal content: {}", tl.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
                .start();

        new Thread(
                        () -> {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                                tl.set("zack");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
                .start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
    }
}
