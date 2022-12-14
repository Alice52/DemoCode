package cn.edu.ntu.java.javase.thread.share;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class RunnableShareVariable {

    public static void main(String[] args) {
        AppleRunnable appleRunnable = new AppleRunnable();
        new Thread(appleRunnable).start();
        new Thread(appleRunnable).start();
        new Thread(appleRunnable).start();
    }

    public static class AppleRunnable implements Runnable {
        // 这个变量是共享的: new AppleRunnable() 多个时彼此独立
        private int appleCount = 500;

        // 一次拿一个
        @SneakyThrows
        private synchronized boolean getApple() {
            if (appleCount > 0) {
                appleCount--;
                TimeUnit.MICROSECONDS.sleep(1000);
                log.info(Thread.currentThread().getName() + " 拿走了一个苹果, 还剩下" + appleCount + "个苹果！");
                return true;
            } else {
                log.info(Thread.currentThread().getName() + " 已经死了！");
                return false;
            }
        }

        /**
         * 不停的拿, 拿到没有结束
         */
        @Override
        public void run() {
            boolean flag = getApple();
            // 多线程这里一定要写 true, 不能时 if
            while (flag) {
                flag = getApple();
            }
        }
    }
}
