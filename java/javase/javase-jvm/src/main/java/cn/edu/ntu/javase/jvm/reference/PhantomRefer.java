package cn.edu.ntu.javase.jvm.reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-03-02 16:11 <br>
 * @project javase <br>
 */
@Slf4j
public class PhantomRefer {

    @SneakyThrows
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference phantomRefer = new PhantomReference(obj, queue);

        // java.lang.Object@179d3b25
        log.info("obj: {}", obj);
        // null
        log.info("softReference: {}", phantomRefer.get());
        // null
        log.info("queue: {}", queue.poll());

        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        // null
        log.info("obj: {}", obj);
        // null
        log.info("softReference: {}", phantomRefer.get());
        // java.lang.ref.PhantomReference@685f4c2e
        log.info("queue: {}", queue.poll());
    }
}
