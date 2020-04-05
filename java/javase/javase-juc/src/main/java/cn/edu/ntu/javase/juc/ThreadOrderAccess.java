package cn.edu.ntu.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zack
 * @create 2019-12-06 21:48
 * @function A -- B -- C -- A -- B -- C ...
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource data = new ShareResource();
        new Thread(() -> {for (int i = 1; i <= 10; i++) data.executeA(i); },"A").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) data.executeB(i); },"B").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) data.executeC(i); },"C").start();
    }
}

class ShareResource {
    private static final Logger LOG = LoggerFactory.getLogger(ShareResource.class);
    // flag: A-1; B-2; C-3;
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    // like key of lock
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void executeA(int loopTimes) {
        lock.lock();

        try{
            // judge
            while ( flag != 1)
                conditionA.await();

            // work
            LOG.info(Thread.currentThread().getName() + " execute " + loopTimes +" times");

            // notice
            flag = 2;
            conditionB.signal();

        } catch (Exception e){

        }finally{
            lock.unlock();
        }
    }

    public void executeB(int loopTimes) {
        lock.lock();

        try{
            // judge
            while ( flag != 2)
                conditionB.await();

            // work
                LOG.info(Thread.currentThread().getName() + " execute " + loopTimes +" times");

            // notice
            flag = 3;
            conditionC.signal();

        } catch (Exception e){

        }finally{
            lock.unlock();
        }
    }

    public void executeC(int loopTimes) {
        lock.lock();

        try{
            // judge
            while ( flag != 3)
                conditionC.await();

            // work
                LOG.info(Thread.currentThread().getName() + " execute " + loopTimes +" times");

            // notice
            flag = 1;
            conditionA.signal();

        } catch (Exception e){

        }finally{
            lock.unlock();
        }
    }
}
