package cn.edu.ntu.javase.collection.map;

import cn.hutool.core.util.StrUtil;

import java.io.*;
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
    try {
      BufferedReader bufferedReader =
          new BufferedReader(new InputStreamReader(new FileInputStream(TEST_DATA_PATH)));

      Map<String, Integer> map = new HashMap<>(16);

      String str;
      while ((str = bufferedReader.readLine()) != null) {
        String[] arr = str.replace(StrUtil.COMMA, StrUtil.SPACE).split(StrUtil.SPACE);
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
      // method1: Collections.sort(List<T> list, Comparator<? super T> c),之后装入map中
      List<Map.Entry<String, Integer>> entriesList = new ArrayList<>(map.entrySet());
      Collections.sort(entriesList, Comparator.comparing(x -> x.getValue()));

      // method2: LinkedHashMap是有序的
      Map<String, Integer> map3 = new LinkedHashMap<>();
      entriesList.forEach(entry -> map3.put(entry.getKey(), entry.getValue()));
      map3.forEach((k, v) -> System.out.println(k + " " + v));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
