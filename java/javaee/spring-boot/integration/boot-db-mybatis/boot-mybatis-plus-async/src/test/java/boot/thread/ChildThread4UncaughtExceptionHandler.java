package boot.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-06-01 09:43 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class ChildThread4UncaughtExceptionHandler implements Runnable {
    private static Thread.UncaughtExceptionHandler exceptionHandler =
            (t, e) -> log.error(String.format("handle exception in child thread. %s", e));

    @SneakyThrows
    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(exceptionHandler);
        doSomething1();
        TimeUnit.SECONDS.sleep(5);
        exceptionMethod();
        doSomething2();
    }

    @SneakyThrows
    private void exceptionMethod() {
        throw new Exception("occur exception");
    }

    private void doSomething2() {
        log.info("execute doSomething2 ...");
    }

    private void doSomething1() {
        log.info("execute doSomething1 ...");
    }
}
