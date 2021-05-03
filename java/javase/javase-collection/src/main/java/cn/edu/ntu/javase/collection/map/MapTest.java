package cn.edu.ntu.javase.collection.map;

import cn.hutool.core.util.StrUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 统计TXT文件中每个单次出现的次数<br>
 *
 * @author zack <br>
 * @create 2020-04-04 22:26 <br>
 */
public class MapTest {
    private static final String TEST_DATA_PATH =
            "F:\\repository\\Algorithms\\deprecate\\algs4-data\\movies.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(TEST_DATA_PATH)));

        Map<String, Integer> map = new HashMap<>(16);

        String str;
        for (; (str = bufferedReader.readLine()) != null; ) {
            String[] arr = str.replace(StrUtil.COMMA, StrUtil.SPACE).split(StrUtil.SPACE);
            Arrays.stream(arr).forEach(x -> map.compute(x, (k, v) -> v == null ? 1 : ++v));
        }
        bufferedReader.close();

        // 按照 key 排序
        Map<String, Integer> map2 = new TreeMap<>(Comparator.naturalOrder());
        map2.putAll(map);

        // 案值排序: 相对计较麻烦, 将map中的键值对放入list列表中
        // method1: Collections.sort(List<T> list, Comparator<? super T> c)
        new ArrayList<>(map.entrySet()).sort(Map.Entry.comparingByValue());
    }
}
