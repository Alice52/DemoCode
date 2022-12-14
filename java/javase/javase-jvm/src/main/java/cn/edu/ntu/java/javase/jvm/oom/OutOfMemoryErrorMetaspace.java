package cn.edu.ntu.java.javase.jvm.oom;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author zack <br>
 * @create 2021-03-02 17:29 <br>
 * @project javase <br>
 */
@Slf4j
public class OutOfMemoryErrorMetaspace {

    public static void main(String[] args) {

        Optional.ofNullable(OmmTest.obj).ifPresent(System.out::println);
    }

    static class OmmTest {
        static Object obj = new byte[500 * 1024 * 1024];
    }
}
