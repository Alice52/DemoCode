package cn.edu.ntu.javase.interview.list;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 线程不安全
 *
 * <pre>
 *     1. HashSet 底层时 HashMap, put 方法的Key 作为 HashMap 的Key, HashMap 的 Value 时默认值
 *     2. 线程安全
 *          - {@link java.util.Collections#synchronizedSet(Set)}
 *          - {@link java.util.concurrent.CopyOnWriteArraySet } 底层是 {@link java.util.concurrent.CopyOnWriteArrayList }
 *
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-23<br>
 * @project javase <br>
 */
public class UnsafeHashSet {

  public static void main(String[] args) {
    Set<String> hashSet = Collections.synchronizedSet(new HashSet<>());
  }
}
