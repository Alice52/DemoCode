package cn.edu.ntu.javase.jvm.oom;

import lombok.extern.slf4j.Slf4j;
import sun.misc.VM;

import java.nio.ByteBuffer;
import java.util.OptionalLong;

/**
 * @author zack <br>
 * @create 2021-03-02 16:29 <br>
 * @project javase <br>
 */
@Slf4j
public class DisplayOutOfMemoryErrorDirect {
    /**
     *
     *
     * <pre>
     *     1. -Xms20m -Xmx20m -XX:MaxDirectMemorySize=5m
     *     2. java.lang.OutOfMemoryError: Direct buffer memory
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {

        OptionalLong.of(VM.maxDirectMemory())
                .ifPresent(
                        x -> log.info("max direct memory: {}", x / (double) 1024 / (double) 1024));

        ByteBuffer.allocateDirect(10 * 1024 * 1024);
    }
}
