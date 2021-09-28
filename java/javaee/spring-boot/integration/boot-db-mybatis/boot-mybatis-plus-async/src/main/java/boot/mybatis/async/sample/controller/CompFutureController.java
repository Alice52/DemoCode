package boot.mybatis.async.sample.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture 中异常问题:
 *
 * <pre>
 *     1. join/get 等可以使得子线程的异常被抛出, 进而被 mvc 的全局异常处理器处理
 *     2. @Async 内的子线程异常默认就可以被 mvc 的全局异常处理器处理
 *     3. 如果是不影响主线程的异步业务, 则需要自己去捕获异常, 否则会出现业务没执行, 也没有任何 log 的诡异
 *          - 因此需要自己一定要在外层 try..catch
 * </pre>
 *
 * @see boot.thread.SubThreadExceptionTest 子线程异常处理
 * @author zack <br>
 * @create 2021-05-31 16:02 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@RestController("/async")
public class CompFutureController {

    /** 一定会执行 */
    @GetMapping("/log")
    public void testAsyncLog() {
        CompletableFuture.runAsync(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("testAsyncLog...");
                });
    }

    /** 不需要结果的异步需要在最外层自己 try..catch */
    @GetMapping("/exception")
    public void testAsyncException() {
        CompletableFuture.runAsync(
                () -> {
                    try {
                        throwException();
                    } catch (Exception ex) {
                        log.error("occur exception when sendSignUpMsg with params: {}", "dsd", ex);
                    }
                });
    }

    /** 错误的典型, 一定要 try...catch 获取 join/get */
    @GetMapping("/exception-v0")
    @Deprecated
    public void testAsyncExceptionV0() {
        CompletableFuture.runAsync(this::throwException);
    }

    @SneakyThrows
    private void throwException() {
        throw new Exception("dsdsfd");
    }
}
