package cn.edu.ntu.java.javase.interview.vol;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-01-18<br>
 * @project javase <br>
 */
@Slf4j
public class CommandResort {
    int a = 0;
    boolean flag = false;

    /**
     * 这里可能存在指令重排, 则在超多线程都在执行 m0, m2 时会出问题, 导致结果不唯一
     *
     * <pre>
     *      1. flag 在第一句: 就会导致线程执行 m2 时, 且在 a=1 执行之前执行, a=5
     *      2. flag 在第二句: 就会导致线程执行 m2 时,  a=6
     *      3. solution: 在 a 和 flag 之前都加上 volatile 指定涉及到这两个的都不循序指令重排, 则 a=6
     * </pre>
     */
    public void m0() {
        a = 1;
        flag = true;
    }

    public void m2() {
        if (flag) {
            a = a + 5;
            log.info("a: {}", a);
        }
    }
}
