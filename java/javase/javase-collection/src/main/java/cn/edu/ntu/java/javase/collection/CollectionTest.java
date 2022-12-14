package cn.edu.ntu.java.javase.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author zack <br>
 * @create 2020-04-04 22:13 <br>
 */
@Slf4j
public class CollectionTest {

    @Test
    public void testCollectionRetainAll() {
        Collection a = new ArrayList(Arrays.asList("a", "b", "c", "d"));
        Collection b = new ArrayList(Arrays.asList("ab", "bc", "e", "f"));
        b.add("g");
        // a will become intersection
        a.retainAll(b);

        a.stream().forEach(System.out::println);
        b.stream().forEach(System.out::println);

        if (a.size() > 0) {
            log.info("have intersection");
        } else {
            log.info("have no intersection");
        }
    }

    @Test
    public void testCollectionUnion() {
        Collection a = new ArrayList(Arrays.asList("a", "b", "c", "d"));
        Collection b = new ArrayList(Arrays.asList("ab", "bc", "e", "f"));
        b.add("g");
        // a will become union
        a.addAll(b);
    }
}
