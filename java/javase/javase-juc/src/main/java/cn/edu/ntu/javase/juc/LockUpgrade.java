package cn.edu.ntu.javase.juc;

import cn.edu.ntu.javase.common.model.Person;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-05-02 15:11 <br>
 * @project javase <br>
 */
@Slf4j
public class LockUpgrade {

    @SneakyThrows
    public static void main(String[] args) {

        // 1. 无锁: 创建出一个对象默认就是无锁状态
        // 反向的获取 对应 图片的顺序
        Person tmpPerson = new Person();
        // 00000000 00000000 00000000 00000001
        log.info("无锁状态(001): {}", ClassLayout.parseInstance(tmpPerson).toPrintable());

        // 2. 偏向锁: 改线程5s 之后创建的对象会变为偏向锁
        // 2.1 可以通过 -XX:BiasedLockingStartupDelay=0 取消延时; 可以通过 -XX:-UseBiasedLocking=false 取消偏向锁
        TimeUnit.SECONDS.sleep(5);
        Person p1 = new Person();
        // 00000000 00000000 00000000 00000101
        log.info("偏向锁状态(101): {}", ClassLayout.parseInstance(p1).toPrintable());

        // 2.2 偏向锁加锁会将线程ID写入对象头
        synchronized (p1) {
            // 00000011 00010101 00111000 00000101
            log.info("偏向锁状态(101) With Thread-ID: {}", ClassLayout.parseInstance(p1).toPrintable());
        }
        // 2.3 偏向锁释放不会将线程ID移出对象头: 偏向此线程; 所以结果与上一次完全相同(00000011 00010101 00111000 00000101)
        log.info("偏向锁状态(101) With Thread-ID 释放: {}", ClassLayout.parseInstance(p1).toPrintable());

        // 3. 轻量级锁: 多个线程加锁竞争[轻度](两个线程对同一个对象加锁就会升级为轻量级锁)
        // 3.1 指向 monitor, 且会把对象分带年龄存入其他的地方, 解锁的时候会写回来
        new Thread(
                        () -> {
                            synchronized (p1) {
                                // 00011111 11011100 11110100 01000000
                                log.info(
                                        "轻量级锁状态(00): {}",
                                        ClassLayout.parseInstance(p1).toPrintable());
                                // 不释放锁, 下面的锁会默认自旋10次[会有自适应调节], 升级为重量级锁
                                try {
                                    TimeUnit.SECONDS.sleep(5);
                                } catch (InterruptedException e) {
                                }
                            }
                        })
                .start();

        // 4. 重量级锁: 重度竞争[自适应自旋(默认10次)], 轻量级锁会升级为重量级锁
        // 4.1 指向 monitor, 且会把对象分带年龄存入其他的地方, 解锁的时候会写回来
        new Thread(
                        () -> {
                            synchronized (p1) {
                                // 00011100 10101000 11110100 11111010
                                log.info(
                                        "重量级锁状态(10): {}",
                                        ClassLayout.parseInstance(p1).toPrintable());
                            }
                        })
                .start();

        TimeUnit.SECONDS.sleep(15);

        // 5. 锁释放:
        // 5.1 偏向锁锁的释放前后没有任何改变
        // 5.2 轻量级锁的释放会完全释放至无锁状态
        // 5.3 重量级锁的释放会完全释放至无锁状态
        // 00000000 00000000 00000000 00000001
        log.info("所释放后的无锁状态(001): {}", ClassLayout.parseInstance(p1).toPrintable());
    }
}
