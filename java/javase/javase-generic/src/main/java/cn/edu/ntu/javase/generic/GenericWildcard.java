package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;

import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class GenericWildcard<E> {

  /**
   * dest and src must have same type.<br>
   *
   * @param dest
   * @param src
   * @param <T>
   * @see {@link GenericWildcard#mergeSameType2(List, List)}
   */
  @Deprecated
  public static <T extends Person> void mergeSameType(List<T> dest, List<T> src) {
    src.forEach(x -> dest.add(x));
  }

  /**
   * This is real generic.
   *
   * @param dest
   * @param src
   * @param <T>
   */
  public <T extends E> void mergeSameType2(List<T> dest, List<T> src) {
    src.forEach(x -> dest.add(x));
  }

  /**
   * Can merge student to person.
   *
   * @param dest
   * @param src
   * @param <T>
   */
  public static <T> void merge(List<? super T> dest, List<T> src) {
    src.forEach(x -> dest.add(x));
  }
}
