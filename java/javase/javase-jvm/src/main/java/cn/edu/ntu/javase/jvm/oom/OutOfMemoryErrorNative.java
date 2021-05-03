package cn.edu.ntu.javase.jvm.oom;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-03-02 17:22 <br>
 * @project javase <br>
 */
@Slf4j
public class OutOfMemoryErrorNative {

    /**
     * java.lang.OutOfMemoryError: unable to create new native thread
     *
     * @param args
     */
    public static void main(String[] args) {

        int i = 0;

        try {
            while (true) {
                new Thread(
                                () -> {
                                    try {
                                        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                },
                                "AA" + ++i)
                        .start();
                OptionalInt.of(i).ifPresent(System.out::println);
            }

        } finally {

            OptionalInt.of(i).ifPresent(System.out::println);
        }
    }
}
