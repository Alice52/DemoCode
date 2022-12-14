package cn.edu.ntu.java.javase.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * https://github.com/Alice52/java-ocean/issues/15 <br>
 *
 * <pre>
 *     1. 同一资源, 两个非静态同步方法: 按调用的顺序执行
 *     2. 同一资源: 两个非静态同步方法， 第一个 sleep 几秒： 按调用的顺序执行
 *        - 原因1: A 先获取到执行权,  进入 A sleep 4s,  但是并没有交出执行权[lock]
 *        - 原因2： 方法的 synchronized 关键字会锁整个资源, 而不是该方法 this.wait(); // 这样才会先执行 B
 *     3. 资源类内添加普通方法[非同步方法]， 普通方法与锁无关， 会直接执行
 *     4. 两个资源类， 两个同步方法，则两个线程分别使用不同的资源类导致不是同一把锁，所以彼此互不相关
 *     5. 两个静态同步方法, 无论资源个数, 都会按调用的顺序执行
 *        - 原因： static synchronized 锁定的是类模板, 即所有的实例
 *     6. static synchronized 相当于 工厂 synchronized 相当于 产品
 *  </pre>
 *
 * @author zack
 * @create 2019-12-05 19:57
 * @function 8 lock:
 */
public class Lock8 {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> phone.sendSMS(), "A").start();
        // make sure A can first get access
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> Phone.sendEmail(), "B").start();
    }
}

class Phone {
    private static final Logger LOG = LoggerFactory.getLogger(Phone.class);

    public static synchronized void sendEmail() {

        LOG.info(Thread.currentThread().getName() + ", Send Email");
    }

    public synchronized void sendSMS() {
        try {
            TimeUnit.SECONDS.sleep(4);
            // this.wait();
            LOG.info(Thread.currentThread().getName() + ", Send SMS");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openPC() {
        LOG.info(Thread.currentThread().getName() + ", open");
    }
}
