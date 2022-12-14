package cn.edu.ntu.java.javase.interview.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link ReentrantLock } 默认是非公平锁<br>
 * {@code synchronized } 是非公平锁<br>
 *
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
@Slf4j
public class FairLock {
    public static void main(String[] args) {
        // This is equivalent to using {@code ReentrantLock(false)}.
        Lock lock = new ReentrantLock();
    }
}
