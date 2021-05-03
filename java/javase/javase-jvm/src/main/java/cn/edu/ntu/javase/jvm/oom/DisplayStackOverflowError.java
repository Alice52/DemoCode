package cn.edu.ntu.javase.jvm.oom;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-03-02 16:26 <br>
 * @project javase <br>
 */
@Slf4j
public class DisplayStackOverflowError {

    public static void main(String[] args) {
        stackOverflowError();
    }

    /** java.lang.StackOverflowError */
    private static void stackOverflowError() {
        stackOverflowError();
    }
}
