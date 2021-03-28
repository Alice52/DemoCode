package cn.edu.ntu.javase.collection.list;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-02-27 21:36 <br>
 * @project javase <br>
 */
@Slf4j
public class ConcurrentModificationExceptionTest {

  public static void main(String[] args) {
    threadSafe();
    //    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    //    list.forEach(
    //        x -> {
    //          list.add(1);
    //          log.info("element: {}", x);
    //        });
  }

  /** 同时读写一个 List 会出现 ConcurrentModificationException 异常 */
  public static void threadSafe() {
    ArrayList<String> unsafeList = new ArrayList<>();
    IntStream.rangeClosed(1, 1000)
        .forEach(
            i ->
                new Thread(
                        () -> {
                          String uuid = UUID.fastUUID().toString();
                          unsafeList.add(uuid);
                          log.info("{}", unsafeList);
                        },
                        "AAA" + i)
                    .start());
  }
}
