package cn.edu.ntu.javase.syntax;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 15:34 <br>
 */
public class BasicSpaceAllocateTest {

  public static void main(String[] args) {

    Integer a = new Integer(2);
    Integer b = new Integer(2);
    Assert.isFalse(a == b);

    Integer integer = Integer.valueOf(2);
    Integer integer2 = Integer.valueOf(2);
    Assert.isTrue(integer == integer2);
    Assert.isTrue(integer.equals(integer2));

    // automatic inbox
    Integer integer3 = 2;
    Integer integer4 = 2;
    // unboxing here
    Assert.isTrue(integer3 == integer4);
    Assert.isTrue(integer3.equals(integer4));
    Assert.isTrue(integer == integer3);
    Assert.isFalse(a == integer3);

    String String = "123";
    String String2 = "123";
    Assert.isTrue(String == String2);
    Assert.isTrue(String.equals(String2));
  }
}
