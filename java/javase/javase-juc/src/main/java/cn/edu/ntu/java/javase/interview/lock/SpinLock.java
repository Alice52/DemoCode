package cn.edu.ntu.java.javase.interview.lock;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁的好处: 循环比较直到成功, 没有阻塞的上下文切换 <br>
 * 坏处: 长时间自旋消耗 CPU, 拖慢系统响应
 *
 * <pre>
 *     1. 通过 cas 完后才能自旋锁, A 线程进来调用 Lock 方法自己持有锁 5 秒
 *     2. B 线程进来发现当前线程持有锁不是 null, 所以自旋等待, 直到A线程释放锁且B线程抢到
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
@Slf4j
public class SpinLock {

    /**
     * 此时没有被调用所以之内存中还是 null<br>
     * 基本数据类型, new 出来时是默认值,<br>
     * 引用类型则是 null
     */
    private AtomicReference<Thread> reference = new AtomicReference<>();

    @SneakyThrows
    public static void main(String[] args) {
        SpinLock lock = new SpinLock();

        new Thread(
                () -> {
                    try {
                        lock.Lock();
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                    } finally {
                        lock.UnLock();
                    }
                },
                "AAA")
                .start();

        // 保证 AAA 先获取到锁
        TimeUnit.SECONDS.sleep(1);

        new Thread(
                () -> {
                    try {
                        lock.Lock();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    } finally {
                        lock.UnLock();
                    }
                },
                "BBB")
                .start();
    }

    private void Lock() {

        // 成功比较并设置则停止循环
        while (!reference.compareAndSet(null, Thread.currentThread())) {
            // logic
            log.info("thread: {} do-while", Thread.currentThread().getName());
        }
        log.info("thread: {} got lock", Thread.currentThread().getName());
    }

    private void UnLock() {
        reference.compareAndSet(Thread.currentThread(), null);
        log.info("thread: {} unlock", Thread.currentThread().getName());
    }
}
