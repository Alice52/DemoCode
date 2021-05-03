package cn.edu.ntu.javase.interview.vol;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-01-18<br>
 * @project javase <br>
 */
@Slf4j
public class VolatileVisible {

    public static void main(String[] args) {
        // 1. 资源类
        VolatileData data = new VolatileData();

        // 2. 第一个线程: 3秒之后修改为 60
        new Thread(
                        () -> {
                            log.info("thread: {} come in", Thread.currentThread().getName());

                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                            }
                            log.info(
                                    "thread: {} update number value to: {}",
                                    Thread.currentThread().getName(),
                                    data.number);

                            data.addTo60();
                        },
                        "AAA")
                .start();

        /**
         * volatile 的可见性
         *
         * <pre>
         *     1. number 前没有 volatile 关键字: 彼此线程不可见
         *          - 会一直 block: main 线程在最初的时候加载到自己的工作空间的是 0, AAA 线程修改对 main 线程是不可见的[即使AAA把数据写回了主内存]
         *     2. number 前有 volatile 关键字: 彼此线程可见[主内存实现]
         *          - 则不会 block 在这里, main 可以拿到修改后的值
         * </pre>
         */
        while (data.number == 0) {
            // 只要不等于 0 则向下执行
        }

        log.info(
                "thread: {} get number value is {}", Thread.currentThread().getName(), data.number);
    }
}
