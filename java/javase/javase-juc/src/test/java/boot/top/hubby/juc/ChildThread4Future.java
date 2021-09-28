package top.hubby.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author zack <br>
 * @create 2021-06-01 09:30 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class ChildThread4Future implements Callable<String> {
    public String call() throws Exception {
        doSomething1();
        exceptionMethod();
        doSomething2();
        return "test result";
    }

    private void exceptionMethod() {
        throw new RuntimeException("ChildThread4Future exception");
    }

    private void doSomething2() {
        log.info("execute doSomething2 ...");
    }

    private void doSomething1() {
        log.info("execute doSomething1 ...");
    }
}
