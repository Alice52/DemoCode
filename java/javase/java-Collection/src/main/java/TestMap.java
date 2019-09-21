import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 统计TXT文件中每个单次出现的次数：
 */
@SuppressWarnings("unused")
public class TestMap {
    private static final String TEST_DATA_PATH = "F:\\repository\\algs4-data\\movies.txt";
    private static final String SPACE = " ";
    private static final String SPACE_AND_POT = ", ";


    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(TEST_DATA_PATH)));
            Map<String, Integer> map = new HashMap<>();

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.replace(SPACE_AND_POT, SPACE).split(SPACE);
                for (String s : arr) {
                    if (map.get(s) == null) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
            bufferedReader.close();

            // 按照 key 排序
            Map<String, Integer> map2 = new TreeMap<>(Comparator.naturalOrder());
            map2.putAll(map);

            // 案值排序: 相对计较麻烦 原理：将map中的键值对放入list列表中，
            // Collections.sort(List<T> list, Comparator<? super T> c),之后装入map中
            List<Map.Entry<String, Integer>> entriesList = new ArrayList<>(map.entrySet());
            Collections.sort(entriesList, Comparator.comparing(x -> x.getValue()));
            Map<String, Integer> map3 = new LinkedHashMap<>();  //LinkedHashMap是有序的
            entriesList.forEach(entry -> map3.put(entry.getKey(), entry.getValue()));
            map3.forEach((k, v) -> System.out.println(k + " " + v));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
