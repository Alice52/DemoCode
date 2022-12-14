package cn.edu.ntu.java.javase.jvm.oom;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-03-02 16:29 <br>
 * @project javase <br>
 */
@Slf4j
public class DisplayOutOfMemoryErrorHeapGC {
    /**
     *
     *
     * <pre>
     *     1. -Xms20m -Xmx20m -XX:MaxDirectMemorySize=5m
     *     2. java.lang.OutOfMemoryError: GC overhead limit exceeded[i is 118623]
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Exception e) {
            log.info("i : {}", i);
            throw e;
        }
    }
}
