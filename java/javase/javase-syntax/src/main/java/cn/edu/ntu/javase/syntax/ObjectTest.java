package cn.edu.ntu.javase.syntax;

import cn.hutool.core.lang.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * this is for Object methods test.<br>
 *
 * @author zack
 * @create 2020-01-30 12:33
 */
public class ObjectTest {
  private static final Logger LOG = LoggerFactory.getLogger(ObjectTest.class);

  /**
   * The compiler checks whether obj can be converted to the class type correctly. <br>
   * If it cannot be converted, an error is reported directly.<br>
   * If the type cannot be determined, it is compiled success.<br>
   */
  @Test
  public void testInterface() {
    boolean flag = new String() instanceof Comparable;
    Assert.isTrue(flag);
    LOG.info("interface can be instance template: " + flag);
  }

  @Test
  public void testType() {
    Integer i = new Integer(10);
    boolean flag = i instanceof Integer;
    Assert.isTrue(flag);
    LOG.info("instance template should be Reference type: " + flag);
  }

  @Test
  public void testNullType() {
    // null is a special symbol that can be any reference type.
    boolean flag = null instanceof Comparable;
    Assert.isFalse(flag);
    LOG.info("null can be obj, but it will not be any Object instance: " + flag);
  }

  @Test
  public void testExtends() {
    ArrayList arrayList = new ArrayList();
    boolean flag = arrayList instanceof List;
    Assert.isTrue(flag);

    List list = new ArrayList();
    boolean flagB = list instanceof ArrayList;
    Assert.isTrue(flagB);
  }
}
