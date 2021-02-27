package cn.edu.ntu.javase.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author zack <br/>
 * @create 2021-02-27 18:05 <br/>
 * @project javase <br/>
 */
public class Traverse {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 1. 超级 for 循环遍历
        for(int attribute : list) {
            System.out.println(attribute);
        }

        // 2. 对于 ArrayList 来说速度比较快, 用 for 循环, 以 size 为条件遍历:
        for(int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }

        // 3. 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // 4.Stream()
        list.stream().forEach(System.out::println);
    }

}
