package cn.edu.ntu.javase.interview.vol;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-01-20<br>
 * @project javase <br>
 */
@Slf4j
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        log.info("construct...");
    }

    /**
     * * 单例模式的线程安全:
     *
     * <pre>
     *     1. 没有任何修饰[synchronized]的时候时线程不安全的:
     *     2. 可以使用 synchronized 可以解决: 性能不好, 不能做到多个线程同时获取这个对象
     * </pre>
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /**
     * 线程安全.
     *
     * @return
     */
    public static synchronized Singleton getInstanceV1() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /**
     * DCL: 双端检锁机制, 在加锁前后都检查<br>
     * 还是线程不安全的[未初始化的对象]: 指令重排导致的
     *
     * <pre>
     *     1. new Singleton()
     *         - 分配内存空间
     *         - 初始化对象
     *         - 设置 instance 指向刚分配的内存地址
     *     2. 由于指令重排的话可能是 1-3-2, 此时返回的只是内存空间还没有初始化
     *     3. 在变量前加 volatile 禁止指令重排
     * </pre>
     *
     * @return
     */
    public static Singleton getInstanceV2() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        //    IntStream.rangeClosed(0, 1000000)
        //        .forEach(x -> new Thread(() -> Singleton.getInstance(), "AAA" + x).start());

        IntStream.rangeClosed(0, 1000000)
                .forEach(x -> new Thread(() -> Singleton.getInstanceV2(), "BBB" + x).start());
    }
}
