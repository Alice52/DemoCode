package cn.edu.ntu.javase.jvm.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;

/**
 * 内存足够的时候不 GC, 内存不够的时候会被回收
 *
 * @author zack <br>
 * @create 2021-03-02 15:20 <br>
 * @project javase <br>
 */
@Slf4j
public class WeakRefer {

    public static void main(String[] args) {

        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        log.info("o: {}", o);
        log.info("softReference: {}", weakReference.get());

        o = null;
        System.gc();
        // null
        log.info("o: {}", o);
        // null
        log.info("softReference: {}", weakReference.get());
    }
}
