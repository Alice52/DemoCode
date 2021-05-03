package cn.edu.ntu.javase.juc;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 最终的打印结果与 for 的顺序十分相关
 *
 * @author zack <br>
 * @create 2021-01-24<br>
 * @project javase <br>
 */
@Slf4j
public class RWLock {

    public static void main(String[] args) throws InterruptedException {

        MyCache cache = new MyCache();

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            new Thread(() -> cache.setSafeV2("a" + finalI, finalI), "AAA" + i).start();
            // new Thread(() -> cache.getSafeV2("a" + finalI), "BBB" + i).start();
        }

        // 保证写操作完后才能读取
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            new Thread(() -> cache.get("a" + finalI), "BBB" + i).start();
        }
    }
}

@Slf4j
@Getter
class MyCache {
    private volatile Map<String, Object> cache = new HashMap<>();
    private Lock lock = new ReentrantLock();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * 这里的写操作会出现被打断的情况: 线程不安全, 可能会出现 cache 中的元素变少或者为 null 的情况
     *
     * @param key
     * @param value
     * @see cn.edu.ntu.javase.interview.list.UnsafeHashMap
     */
    @SneakyThrows
    public void set(String key, Object value) {
        log.info("thread: {} is writing key {}", Thread.currentThread().getName(), key);
        TimeUnit.MICROSECONDS.sleep(300);
        cache.put(key, value);
        log.info("thread: {} is write done", Thread.currentThread().getName());
    }

    /**
     * 写操作是线程安全的, 且只保证写操作的线程安全.<br>
     * 如果调用 set 非线程安全操作, 则会在写操作之间读操作的log<br>
     *
     * @param key
     * @param value
     */
    @SneakyThrows
    public void setSafe(String key, Object value) {
        lock.lock();
        try {
            log.info("thread: {} is writing key {}", Thread.currentThread().getName(), key);
            TimeUnit.MICROSECONDS.sleep(300);
            cache.put(key, value);
            log.info("thread: {} is write done", Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    /**
     * 写锁是独占锁: 原子 + 独占
     *
     * @param key
     * @param value
     */
    @SneakyThrows
    public void setSafeV2(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            log.info("thread: {} is writing key {}", Thread.currentThread().getName(), key);
            TimeUnit.MICROSECONDS.sleep(300);
            cache.put(key, value);
            log.info("thread: {} is write done", Thread.currentThread().getName());
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    @SneakyThrows
    public Object get(String key) {
        log.info("thread: {} is read key {}", Thread.currentThread().getName(), key);
        TimeUnit.MICROSECONDS.sleep(300);
        Object o = cache.get(key);
        log.info("thread: {} is read done {}", Thread.currentThread().getName(), o);
        return o;
    }

    @SneakyThrows
    public Object getSafe(String key) {
        lock.lock();
        try {
            log.info("thread: {} is read key {}", Thread.currentThread().getName(), key);
            TimeUnit.MICROSECONDS.sleep(300);
            Object o = cache.get(key);
            log.info("thread: {} is read done {}", Thread.currentThread().getName(), o);
            return o;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 读锁是共享锁
     *
     * @param key
     * @return
     */
    @SneakyThrows
    public Object getSafeV2(String key) {
        rwLock.readLock().lock();
        try {
            log.info("thread: {} is read key {}", Thread.currentThread().getName(), key);
            TimeUnit.MICROSECONDS.sleep(300);
            Object o = cache.get(key);
            log.info("thread: {} is read done {}", Thread.currentThread().getName(), o);
            return o;
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
