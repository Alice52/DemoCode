package cn.edu.ntu.java.javase.thread.create;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 每个 futureTask 只能有效的与一个线程绑定
 *
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class CallableCreate {
    @SneakyThrows
    public static void main(String[] args) {
        log.info("main method start ...");
        FutureTask<Integer> futureTask = new FutureTask<>(new CCallabel());
        new Thread(futureTask, "Callable Thread1").start();
        // 无效
        new Thread(futureTask, "Callable Thread2").start();
        // block
        Integer integer = futureTask.get();
        log.info("main method end ...");
    }

    public static class CCallabel implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log.info("thread-id: {}", Thread.currentThread().getId());
            int i = 10 / 2;
            log.info("logic result: {}", i);
            return i;
        }
    }
}
