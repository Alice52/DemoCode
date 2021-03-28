package cn.edu.ntu.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author zack <br>
 * @create 2021-02-27 16:59 <br>
 * @project javase <br>
 */
@Slf4j
public class Array2List {

  public static void main(String[] args) {
    array2ListByArrays();
    array2ListByArrayList();
    array2ListByCollections();
  }

  /**
   * 只能查不能修改添加
   *
   * <pre>
   *     1. {@link Arrays#asList(Object[])} 返回值是 {@link java.util.Arrays.ArrayList}
   *     2. 返回值并没有实现 {@link  AbstractList#add(Object)} 方法
   * </pre>
   *
   * @throws UnsupportedOperationException
   */
  public static void array2ListByArrays() throws UnsupportedOperationException {
    List<Integer> integers = Arrays.asList(1, 2, 3);
    List<int[]> ints = Arrays.asList(new int[] {1, 2, 3});
  }

  /** 利用 ArrayList 构造函数将 java.util.Arrays.ArrayList 转换为 java.util.ArrayList */
  public static void array2ListByArrayList() {
    ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
    integers.add(4);
    integers.forEach(System.out::println);
  }

  /** 使用 Collections#addAll() 效率最高 */
  private static void array2ListByCollections() {
    List<Integer> integers = new ArrayList<>();
    boolean success = Collections.addAll(integers, 1, 2, 3);
    integers.forEach(System.out::println);
  }
}
