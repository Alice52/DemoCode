package cn.edu.ntu.javase.syntax;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * link: https://www.jb51.net/article/111723.htm
 *
 * @author zack <br>
 * @create 2021-03-29 23:19 <br>
 * @project javase <br>
 */
@Slf4j
public class StringTest {

    /**
     * intern
     *
     * <pre>
     *     1. JAVA 虚拟机首先检查字符串池中是否已经存在与该对象值相等对象存在, 如果有则返回字符串池中对象的引用
     *     2. 如果没有, 则先在字符串池中创建一个相同值的 String 对象, 然后再将它的引用返回
     *     3. + 操作只有 都是字符串才会放入字符串常量池, 不能含有变量
     *     4. new String() 是在 heap 中开辟空间; = "" 是在常量池中加入元素[也在 heap 中], 他们不是一个对象
     *     5. 必须是常量相加才会放入常量池: new String() 创建的对象即使加上 final 关键字修饰也还是放在 heap 中
     * </pre>
     */
    @Test
    public void testString() {

        String s1 = "1";
        String s2 = "1";

        Assert.isTrue(s1.equals(s2));
        Assert.isTrue(s1 == s2);
        Assert.isFalse("1a" == (s1 + "a"));
        Assert.isTrue((s1 + "a").intern() == (s1 + "a").intern());

        String s10 = "12";
        String s20 = s1 + "2";
        Assert.isFalse(s10 == s20);
        Assert.isTrue(s10.equals(s20));

        final String s202 = s1 + "2";
        Assert.isFalse(s10 == s202);
        Assert.isTrue(s10.equals(s202));

        final String s0 = "1";
        String s203 = s0 + "2";
        Assert.isTrue(s10 == s203);
        Assert.isTrue(s10.equals(s203));

        final String s01 = new String("1");
        String s204 = s01 + "2";
        Assert.isFalse(s10 == s204);
        Assert.isTrue(s10.equals(s204));

        String s11 = "1" + "2";
        String s21 = "1" + "2";
        Assert.isTrue(s11 == s21);
        Assert.isTrue(s11.equals(s21));

        // new 不会将对象放入常量池
        String s3 = new String("1");
        Assert.isTrue(s1.equals(s3));
        Assert.isFalse(s1 == s3);
        Assert.isTrue(s1 == s3.intern());

        String s4 = s1.intern();
        Assert.isTrue(s1.equals(s4));
        Assert.isTrue(s1 == s4);

        String s5 = s3.intern();
        Assert.isTrue(s5.equals(s3));
        Assert.isFalse(s5 == s3);
    }
}
