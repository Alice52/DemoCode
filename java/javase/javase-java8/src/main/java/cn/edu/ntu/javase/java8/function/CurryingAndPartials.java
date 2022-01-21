package cn.edu.ntu.javase.java8.function;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 柯里化: 将一个多参数的函数, 转换为一系列单参数函数
 *
 * @author asd <br>
 * @create 2022-01-20 9:41 AM <br>
 * @project javase <br>
 */
@Slf4j
public class CurryingAndPartials {
    // 未柯里化:
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        log.info(uncurried("Hi ", "Ho"));

        // 柯里化的函数:
        Function<String, UnaryOperator<String>> sum = a -> b -> a + b;
        UnaryOperator<String> hi = sum.apply("Hi ");
        log.info(hi.apply("Ho"));
        log.info(hi.apply("Hey"));
    }
}
