package interfacedef;

import org.junit.Test;

/**
 * @author zack
 * @create 2019-11-22 23:40
 * @function
 */
public class TestInterface {

  @Test
  public void testInterface() {
      A a = () -> 10;
      System.out.println(a.sise());
      System.out.println(a.isEmpty());
  }

    private interface A {
    int a = 5;
    int sise();
    default boolean isEmpty() {
      return sise() == 0;
    }
  }

  @Test
  public void testImplement() {
      EE d = new EE();
      d.say();
  }

    interface AA {
        default void say() {
            System.out.println("A");
        }
    }

    interface BBB  {
        default void say() {
            System.out.println("B");
        }
    }

    interface BB extends  AA{
        default void say() {
            System.out.println("B");
        }
    }

    static class CC implements AA{
        public void say() {
            System.out.println("C");
        }
    }
    static class DD implements AA, BB{

    }
    static class EE extends CC implements  BB{

    }
    // static class DDD implements AA, BBB{} //error
}
