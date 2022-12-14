package cn.edu.ntu.java.javase.jvm.oom;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-03-02 16:29 <br>
 * @project javase <br>
 */
@Slf4j
public class DisplayOutOfMemoryErrorHeap {

    // -Xmx10m -Xms10m
    public static void main(String[] args) {

        // java.lang.OutOfMemoryError: Java heap space
        byte[] bytes = new byte[50 * 1024 * 1024];
    }
}
