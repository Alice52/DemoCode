package cn.edu.ntu.javase.generic;

import lombok.SneakyThrows;

import java.lang.reflect.ParameterizedType;

/**
 * Generic class with generic method.
 *
 * @author zack <br>
 * @create 2020-04-04 22:51 <br>
 */
public class GenericClass<T> {

  @SneakyThrows
  public T createInstance(Class<T> clazz) {

    return clazz.newInstance();
  }

  @SneakyThrows
  public T createInstance2() {

    ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
    Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
    T o = (T) clazz.newInstance();

    return o;
  }
}
