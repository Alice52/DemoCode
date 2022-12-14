package cn.edu.ntu.java.javase.java8;

import cn.hutool.core.lang.Assert;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2020-04-04 21:28 <br>
 */
public class InterfaceTest {
    @Test
    public void testInterface() {
        A a = () -> 10;
        System.out.println(a.size());
        System.out.println(a.isEmpty());
    }

    @Test
    public void testImplement() {
        EE d = new EE();
        Assert.isTrue("CC".equals(d.say()));
    }

    private interface A {
        int a = 5;

        int size();

        default boolean isEmpty() {
            return size() == 0;
        }
    }

    interface AA {
        default String say() {
            return "AA";
        }
    }

    interface BBB {
        default String say() {
            return "BBB";
        }
    }

    interface BB extends AA {
        default String say() {
            return "BB";
        }
    }

    static class CC implements AA {
        public String say() {
            return "CC";
        }
    }

    static class DD implements AA, BB {}

    static class EE extends CC implements BB {}

    // static class DDD implements AA, BBB{} //error
}
