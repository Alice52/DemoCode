package cn.edu.ntu.javase.interview.list;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 线程不安全
 *
 * <pre>
 *     1. HashSet 底层时 HashMap, put 方法的Key 作为 HashMap 的Key, HashMap 的 Value 时默认值
 *     2. 线程安全
 *          - {@link java.util.Collections#synchronizedMap(Map)}
 *          - {@link java.util.concurrent.ConcurrentMap } 底层是 {@link java.util.concurrent.CopyOnWriteArrayList }
 *     3. 只有读取整个对象时才会出现 {@link java.util.ConcurrentModificationException } 异常;
 *     4. 当取值指定key 只是会读取到的值为 null[线程不安全]
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
@Slf4j
public class UnsafeHashMap {

  public static void main(String[] args) {

    Map<String, String> safeMap = Collections.synchronizedMap(new HashMap<String, String>());

    HashMap<String, Object> unsafeMap = new HashMap<>(10);

    IntStream.rangeClosed(1, 100)
        .forEach(
            i ->
                new Thread(
                        () -> {
                          String key = UUID.randomUUID().toString();
                          unsafeMap.put(key, key);
                          log.info("map: {}", unsafeMap); // exception
                          log.info("map: {}", unsafeMap.get(key)); // unsafe
                        },
                        "AAA" + i)
                    .start());
  }
}
