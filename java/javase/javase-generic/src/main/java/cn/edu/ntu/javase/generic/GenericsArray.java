package cn.edu.ntu.javase.generic;

import lombok.val;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-04-22 14:10 <br>
 */
public class GenericsArray {

  public static <T> T[] getArray(Class<T> componentType, int length) {
    return (T[]) Array.newInstance(componentType, length);
  }

  public static <T> List<T> getList(Class<T> componentType)
      throws IllegalAccessException, InstantiationException {
    Field[] declaredFields = componentType.getDeclaredFields();
    Arrays.stream(declaredFields).forEach(System.out::println);
    List<T> list = new ArrayList<>();
    T t = componentType.newInstance();
    list.add(t);

    return list;
  }
}
