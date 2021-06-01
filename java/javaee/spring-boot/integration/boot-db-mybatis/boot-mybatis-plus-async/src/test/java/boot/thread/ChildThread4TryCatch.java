package boot.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-06-01 09:30 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class ChildThread4TryCatch implements Runnable {
    @Override
    public void run() {
        doSomething1();
        try {
            // 可能发生异常的方法
            TimeUnit.SECONDS.sleep(5);
            exceptionMethod();
        } catch (Exception e) {
            // 处理异常
            log.error(String.format("handle exception in child thread. %s", e));
        }
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
