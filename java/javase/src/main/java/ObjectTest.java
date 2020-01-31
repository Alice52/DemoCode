import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.nio.cs.ext.IBM1122;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zack
 * @create 2020-01-30 12:33
 * @function this is for Object methods test.
 */
public class ObjectTest {
  private static final Logger LOG = LoggerFactory.getLogger(ObjectTest.class);

  /**
   * The compiler checks whether obj can be converted to the class type correctly.
   * If it cannot be converted, an error is reported directly.
   * If the type cannot be determined, it is compiled success.
   */
  @Test
  public void testInterface() {
    boolean flag = new String() instanceof Comparable;
    // true
    LOG.info("interface can be instance template: " + flag);
  }

  @Test
  public void testType() {
    Integer i = new Integer(10);
    boolean flag = i instanceof Integer;
    // true
    LOG.info("instance template should be Reference type: " + flag);
  }

  @Test
  public void testNullType() {
    // null is a special symbol that can be any reference type.
    boolean flag = null instanceof Comparable;
    // false
    LOG.info("null can be obj, but it will not be any Object instance: " + flag);
  }

  @Test
  public void testExtends() {
    ArrayList arrayList = new ArrayList();
    boolean flag = arrayList instanceof List;
    // true

    List list = new ArrayList();
    boolean flagB = list instanceof ArrayList;
    // true
  }
}
