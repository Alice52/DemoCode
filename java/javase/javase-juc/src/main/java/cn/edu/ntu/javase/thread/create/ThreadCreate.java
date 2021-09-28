package cn.edu.ntu.javase.thread.create;

import lombok.extern.slf4j.Slf4j;

;

/**
 * Create Thread has 4 methods:
 *
 * <pre>
 *     1. {@link java.lang.Thread}
 *     2. {@link java.lang.Runnable}
 *     3. {@link java.util.concurrent.Callable } and {@link java.util.concurrent.FutureTask}
 *     4. 线程池
 *
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class ThreadCreate {

    public static void main(String[] args) {
        log.info("main method start ...");
        CThread cThread = new CThread();
        cThread.start();

        log.info("main method end ...");
    }

    public static class CThread extends Thread {
        @Override
        public void run() {
            log.info("thread-id: {}", Thread.currentThread().getId());
            int i = 10 / 2;
            log.info("logic result: {}", i);
        }
    }
}
