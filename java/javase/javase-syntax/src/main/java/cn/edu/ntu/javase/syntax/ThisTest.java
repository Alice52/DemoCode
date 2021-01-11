package cn.edu.ntu.javase.syntax;

import cn.hutool.core.lang.Assert;

/**
 * this is for test this scope. </br>
 *
 * @author zack
 * @create 2019-06-07 13:08
 */
public final class ThisTest {
  private int a = 30;

  public static void main(String[] args) {
    ThisTest test1 = new ThisTest();
    test1.test(5);
    Assert.isTrue(560 == test1.a);
  }

  public void test(int b) { // b = 5
    {
      int a = 26;
      {
        Assert.isTrue(26 == a);
        Assert.isTrue(30 == this.a);
        this.a = 560;
        Assert.isTrue(26 == a);
        Assert.isTrue(560 == this.a);
        Assert.isTrue(this instanceof ThisTest);

        a = 11;
        Assert.isTrue(11 == a);
      }
      Assert.isTrue(560 == this.a);
      Assert.isTrue(11 == a);
    }
    Assert.isTrue(560 == this.a);
    Assert.isTrue(560 == a);
  }
}
