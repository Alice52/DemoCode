package cn.edu.ntu.javase.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-04-04 22:09 <br>
 */
public class HashMapTest {
  @Test
  public void testHashPut() {

    // Create a regular (non-tree) node
    // HashMap.Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
    //     return new HashMap.Node<>(hash, key, value, next);
    // }

    Map<String, String> map = new HashMap<>(16);
    // static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    // (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
    // if ((p = tab[i = (n - 1) & hash]) == null)
    //    tab[i] = newNode(hash, key, value, null);
    // put index 7
    map.put("zack", "HH");
    // do nothing
    map.put("zack", "HH");
    // 3730895  1110001110110111001111
    System.out.println("zack hashCode: " + "zack".hashCode());

    Integer a = 132564;
    // 3730895  1110001110110111001111
    System.out.println("132564 hashCode: " + a.hashCode());

    /*
          h = key.hashCode()
           h: 0000 0000 0011 1000 1110 1101 1100 1111
              0000 0000 0000 0000 0000 0000 0011 1000 1110 1101 1100 1111
    h >>> 16: 0000 0000 0000 0000 0000 0000 0011 1000
        hash: h ^ (h >>> 16)
            : 0000 0000 0011 1000 1110 1101 1111 0111
       n - 1: 15
            : 0000 0000 0000 0000 0000 0000 0000 1111
       index: (n - 1) & hash
              0000 0000 0000 0000 0000 0000 0000 0111  // 7
    */
  }
}
