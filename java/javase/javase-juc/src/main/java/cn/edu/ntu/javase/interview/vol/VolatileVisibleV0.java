package cn.edu.ntu.javase.interview.vol;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-01-18<br>
 * @project javase <br>
 */
@Slf4j
public class VolatileVisibleV0 {

    static int number = 0;

    /**
     * 验证无 volatile 时的不可见性
     *
     * @param args
     */
    public static void main(String[] args) {
        // AAA thread will copy number to itself workspace, and do add 1 then write to main memory
        new Thread(() -> ++number, "AAA").start();

        // main thread will copy number[0] to itself workspace, after AAA change number value
        // the number in main thread will also be 0
        while (number == 0) {
            // code will block here
        }

        // unreachable
        log.info("thread: {} get number value is {}", Thread.currentThread().getName(), number);
    }
}
