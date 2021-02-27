package cn.edu.ntu.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.IntStream;

/**
 * @author zack <br>
 * @create 2021-02-27 22:37 <br>
 * @project javase <br>
 */
@Slf4j
public class SourceCode {

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();
    IntStream.rangeClosed(0, 10).forEach(i -> list.add(i));
    IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0).forEach(i -> list.remove(i));

    Optional.of(list.remove(new Integer(5))).ifPresent(System.out::println);

    new Vector<>().add(1);

    new LinkedList<Integer>().element();
  }
}
