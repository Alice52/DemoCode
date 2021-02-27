package cn.edu.ntu.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-02-27 21:36 <br>
 * @project javase <br>
 */
@Slf4j
public class ConcurrentModificationExceptionTest {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    list.forEach(
        x -> {
          list.add(1);
          log.info("element: {}", x);
        });
  }
}
