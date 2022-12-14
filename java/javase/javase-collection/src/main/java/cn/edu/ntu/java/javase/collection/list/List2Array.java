package cn.edu.ntu.java.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2021-02-27 16:59 <br>
 * @project javase <br>
 */
@Slf4j
public class List2Array {

    public static void main(String[] args) {
        list2Array();
    }

    public static void list2Array() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));

        Object[] objects = integers.toArray();
        Integer[] array = integers.toArray(new Integer[]{});
        Arrays.stream(array).forEach(System.out::println);
    }
}
