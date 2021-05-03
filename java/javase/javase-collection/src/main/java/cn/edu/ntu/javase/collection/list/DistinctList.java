package cn.edu.ntu.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zack <br>
 * @create 2021-02-27 20:56 <br>
 * @project javase <br>
 */
@Slf4j
public class DistinctList {
    static ArrayList<Integer> numbers =
            new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

    public static void main(String[] args) {
        distinctByLinkedHashSet();
        distinctForce();

        numbers.forEach(System.out::println);
    }

    /** Use LinkedHashSet to make sure sequence and unique */
    public static void distinctByLinkedHashSet() {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numbers);
        ArrayList<Integer> distinctNumbers = new ArrayList<>(hashSet);
        distinctNumbers.forEach(System.out::println);
    }

    public static void distinctByLambda() {
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        distinctNumbers.forEach(System.out::println);
    }

    /**
     * Use HashSet to make sure unique and add element to new-list, <br>
     * then clear numbers and add new-list elements to numbers
     */
    public static void distinctByHashSet() {
        HashSet<Integer> set = new HashSet<>(numbers.size());
        List<Integer> result = new ArrayList<>(numbers.size());
        for (Integer i : numbers) {
            if (set.add(i)) {
                result.add(i);
            }
        }
        numbers.clear();
        numbers.addAll(result);
    }

    private static void distinctByList() {
        List<Integer> result = new ArrayList<>(numbers.size());
        for (Integer str : numbers) {
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        numbers.clear();
        numbers.addAll(result);
    }

    /** i and j must start from zero */
    @Deprecated
    public static void distinctForce() {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j && numbers.get(i).equals(numbers.get(j))) {
                    numbers.remove(numbers.get(j));
                }
            }
        }
    }
}
