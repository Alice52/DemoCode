package cn.edu.ntu.java.javase.interview.vol;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zack <br>
 * @create 2021-01-18<br>
 * @project javase <br>
 */
public class VolatileData {
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        this.number = 60;
    }

    /**
     * number 前有 volatile 关键字
     *
     * <pre>
     *     1. [证明原子性]: 50 个线程执行 plus 方法 1k 次, 理论上 number 需要是 5w
     *          - 在只有 volatile 修饰时, 线程1 写入主内存后通知线程2[此时被挂起], 所以没收到通知, 线程2[挂起态结束] 就也写入主内存
     *     2. volatile 是不保证原子性即线程不安全:
     *     3. 解决原子性问题:
     *        - 可以使用 synchronized
     *        - 使用 {@link java.util.concurrent.atomic.AtomicInteger}
     * </pre>
     *
     * <pre>
     *     1. number 数据是放入栈中的: 实例的8种基本类型都是在栈中的
     *     2. volatile 中一个线程正在向主内存中写数据, 其他线程会被挂起
     *     3. class
     *     public void plusOneForAtomicTest();
     *       Code:
     *        0: aload_0
     *        1: dup
     *        2: getfield      #2                  // Field number:I  // 从主内存中取
     *        5: iconst_1
     *        6: iadd                                                 // +1
     *        7: putfield      #2                  // Field number:I  // 放回主内存
     *       10: return
     * </pre>
     */
    public void plusOneForAtomicTest() {
        number++;
    }

    /** atomicInteger 前不需要 volatile, 可以保证原子性 */
    public void plusAtomicInteger() {
        atomicInteger.getAndIncrement(); // i++
    }
}
