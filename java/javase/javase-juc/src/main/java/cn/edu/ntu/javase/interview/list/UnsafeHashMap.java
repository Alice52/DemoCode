package cn.edu.ntu.javase.interview.list;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 线程不安全
 *
 * <pre>
 *     1. HashSet 底层时 HashMap, put 方法的Key 作为 HashMap 的Key, HashMap 的 Value 时默认值
 *     2. 线程安全
 *          - {@link java.util.Collections#synchronizedMap(Map)}
 *          - {@link java.util.concurrent.ConcurrentMap } 底层是 {@link java.util.concurrent.CopyOnWriteArrayList }
 *
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
@Slf4j
public class UnsafeHashMap {

  public static void main(String[] args) {

    Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
  }
}
