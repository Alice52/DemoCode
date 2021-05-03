package cn.edu.ntu.javase.jvm.reference;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author zack <br>
 * @create 2021-03-02 15:20 <br>
 * @project javase <br>
 */
@Slf4j
public class WeakHashMapUsage {
    static Integer key = new Integer(1);
    static String value = new String("HashMap");

    public static void main(String[] args) {
        testWeakHashMap();
    }

    public static void testHashMap() {
        HashMap<Integer, String> map = new HashMap<>(16);
        map.put(key, value);
        // map: {1=HashMap}
        log.info("map: {}", map);

        // map: {1=HashMap}
        key = null;
        log.info("map: {}", map);

        // map: {1=HashMap}
        value = null;
        log.info("map: {}", map);
    }

    /**
     * WeakHashMap
     *
     * <pre>
     *    1. WeakHashMap 如果 Key 的引用被置空 GC则回收该 K-V
     *    2. WeakHashMap 如果 Key 的引用被置空 GC 会回收不了
     * </pre>
     */
    public static void testWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>(16);

        map.put(key, value);
        // map: {1=HashMap}
        System.gc();
        log.info("map: {}", map);

        // map: {1=HashMap}
        value = null;
        System.gc();
        log.info("map: {}", map);

        // map: {}
        key = null;
        System.gc();
        log.info("map: {}", map);
    }
}
