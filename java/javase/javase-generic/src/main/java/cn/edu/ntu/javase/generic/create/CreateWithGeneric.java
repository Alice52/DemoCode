package cn.edu.ntu.javase.generic.create;

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class CreateWithGeneric {

  private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<>();

  static {
    wrapperPrimitiveMap.put(Boolean.class, boolean.class);
    wrapperPrimitiveMap.put(Byte.class, byte.class);
    wrapperPrimitiveMap.put(Character.class, char.class);
    wrapperPrimitiveMap.put(Double.class, double.class);
    wrapperPrimitiveMap.put(Float.class, float.class);
    wrapperPrimitiveMap.put(Integer.class, int.class);
    wrapperPrimitiveMap.put(Long.class, long.class);
    wrapperPrimitiveMap.put(Short.class, short.class);
  }

  public static <T> T[] createArray(Class<T> componentType, int length) {
    return (T[]) Array.newInstance(componentType, length);
  }

  @SneakyThrows
  public static <T> List<T> createList(Class<T> componentType, int length) {
    return Arrays.asList((T[]) Array.newInstance(componentType, length));
  }

  @SneakyThrows
  public static <T> List<T> createList(Class<T> componentType) {
    List<T> list = new ArrayList<>();
    T t;
    if (wrapperPrimitiveMap.containsKey(componentType)) {
      t = null;
    } else {
      t = componentType.newInstance();
    }
    list.add(t);

    return list;
  }

  @SneakyThrows
  public static <T> T CreateBasicType(Class<T> clazz, T init) {
    Constructor constructor = clazz.getConstructor(wrapperPrimitiveMap.get(clazz));

    return (T) constructor.newInstance(init);
  }
}
