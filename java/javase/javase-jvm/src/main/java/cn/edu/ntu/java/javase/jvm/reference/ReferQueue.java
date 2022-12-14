package cn.edu.ntu.java.javase.jvm.reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-03-02 16:05 <br>
 * @project javase <br>
 */
@Slf4j
public class ReferQueue {

    @SneakyThrows
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference<Object> weakReference = new WeakReference<>(obj, queue);

        // java.lang.Object@179d3b25
        log.info("obj: {}", obj);
        // java.lang.Object@179d3b25
        log.info("softReference: {}", weakReference.get());
        // null
        log.info("queue: {}", queue.poll());

        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        // null
        log.info("obj: {}", obj);
        // null
        log.info("softReference: {}", weakReference.get());
        // java.lang.ref.WeakReference@685f4c2e
        log.info("queue: {}", queue.poll());
    }
}
