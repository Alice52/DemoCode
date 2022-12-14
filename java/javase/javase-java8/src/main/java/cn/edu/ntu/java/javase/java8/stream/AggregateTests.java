package cn.edu.ntu.java.javase.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author asd <br>
 * @create 2021-12-08 10:40 AM <br>
 * @project javase <br>
 */
@Slf4j
public class AggregateTests {
    @Test
    public void testMax() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        log.info("最长的字符串：" + max.get());
    }

    @Test
    public void testMaxV2() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max2 =
                list.stream()
                        .max(
                                new Comparator<Integer>() {
                                    @Override
                                    public int compare(Integer o1, Integer o2) {
                                        return o1.compareTo(o2);
                                    }
                                });
        log.info("自然排序的最大值：" + max.get());
        log.info("自定义排序的最大值：" + max2.get());
    }
}
