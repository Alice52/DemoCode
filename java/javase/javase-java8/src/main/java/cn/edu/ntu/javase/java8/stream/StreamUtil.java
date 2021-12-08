package cn.edu.ntu.javase.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author asd <br>
 * @create 2021-12-08 10:58 AM <br>
 * @project javase <br>
 */
@Slf4j
public final class StreamUtil {

    public static <T> List<List<T>> split(List<T> list, int splitSize) {
        int limit = (list.size() + splitSize - 1) / splitSize;
        return Stream.iterate(0, f -> f + 1)
                .limit(limit)
                .map(
                        a ->
                                list.stream()
                                        .skip(a * splitSize)
                                        .limit(splitSize)
                                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
