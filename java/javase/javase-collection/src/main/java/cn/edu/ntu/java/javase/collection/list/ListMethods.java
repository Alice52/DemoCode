package cn.edu.ntu.java.javase.collection.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author zack <br>
 * @create 2021-04-13 22:56 <br>
 * @project javase <br>
 */
@Slf4j
public class ListMethods {

    static final Collection<String> set1 =
            new HashSet<String>() {
                {
                    add("a");
                    add("b");
                    add("c");
                }
            };
    static final Collection<String> set2 =
            new HashSet<String>() {
                {
                    add("c");
                    add("d");
                    add("e");
                }
            };

    @Test
    public void testRetainAll() {

        // 交集: set1
        boolean b = set1.retainAll(set2);
        // s1: [c], s2: [c, d, e]
        log.info("s1: {}, s2: {}", set1, set2);
    }

    @Test
    public void testAddAll() {

        // 并集
        boolean b1 = set1.addAll(set2);
        // s1: [a, b, c, d, e], s2: [c, d, e]
        log.info("s1: {}, s2: {}", set1, set2);
    }

    @Test
    public void testRemoveAll() {

        // 差集
        boolean b1 = set1.removeAll(set2);
        // s1: [a, b], s2: [c, d, e]
        log.info("s1: {}, s2: {}", set1, set2);
    }
}
