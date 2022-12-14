package cn.edu.ntu.java.javase.interview.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 注意这里只会出现等待, 不是死锁
 *
 * @author zack <br>
 * @create 2021-03-01 16:02 <br>
 * @project javase <br>
 */
@Slf4j
public class LockCount {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(
                        () -> {
                            lock.lock();
                            lock.lock();
                            try {
                                log.info("execute ...");
                            } finally {
                                lock.unlock();
                                lock.unlock();
                            }
                        },
                        "AA")
                .start();

        new Thread(
                        () -> {
                            lock.lock();
                            try {
                                log.info("execute ...");
                            } finally {
                                lock.unlock();
                            }
                        },
                        "B")
                .start();
    }
}
