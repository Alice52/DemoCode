package java8;

import java.util.HashMap;

/**
 * @author zack
 * @create 2019-11-17 13:08
 * @function
 */
public class HashGet {
    static void run(int mapSize) {
        HashMap<Key, Integer> map = new HashMap<>(mapSize);

        for (int i = 0; i < mapSize; ++i) {
            map.put(Keys.index(i), i);
        }

        long beginTime = System.nanoTime();
        for (int j = 0; j < mapSize; j++) {
            map.get(Keys.index(j));
        }

        long endTime = System.nanoTime();

        System.out.println("getKey avg time: " + (endTime-beginTime)/mapSize);
    }

  public static void main(String[] args) {
    for (int i = 10; i < 10000000; i*=10) {

        System.out.println("getKey number: " + i );
        run(i);
    }
  }
}
