package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.generic.erasure.Erasure;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
@Slf4j
public class ErasureTest {

  /**
   *
   *
   * <pre>
   *     Map map = new HashMap(); // Map<Object, Object> map
   *     map.put("name", "hollis");
   * </pre>
   */
  @Test
  public void testMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "hollis");

    log.info(String.valueOf(map.getClass())); // class java.util.HashMap
  }

  /**
   *
   *
   * <pre>
   *     getDeclaredMethod("add",Object.class): otherwise it will throw exception
   * </pre>
   */
  @Test
  public void testErasure() {
    Erasure<String> erasure = new Erasure();
    erasure.add("asa");
    Class eclz = erasure.getClass();
    Field[] fs = eclz.getDeclaredFields();
    for (Field f : fs) {
      // Field name object type:java.lang.Object
      System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
    }
  }

  @SneakyThrows
  @Test
  public void testE() {
    List<Integer> ls = new ArrayList<>();
    ls.add(23);
    // ls.add("text");
    Method method = ls.getClass().getDeclaredMethod("add", Object.class);
    method.invoke(ls, "test");
    method.invoke(ls, 42.9f);

    for (Object o : ls) {
      System.out.println(o);
    }
  }
}
