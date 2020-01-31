import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-12-13 22:15
 * @function
 *      1. using parent static field will not trigger subClass init, but superClass will init.
 *      2. using as DataType to new array will not trigger this class init.
 *      3. constants are stored in the callee constant pool during compilation, so it will not init constants class
 */
public class ClassInitialization {
  private static final Logger LOG = LoggerFactory.getLogger(ClassInitialization.class);

  public static void main(String[] args) {
    LOG.info(String.valueOf(SubClass.value));
    LOG.info(String.valueOf(new SuperClass[10]));
    LOG.info(ConstClass.HELLO);
  }
}

class SuperClass {
  public static int value = 123;

  static {
    System.out.println("SuperClass init!");
  }
}

class SubClass extends SuperClass {
  static {
    System.out.println("SubClass init!");
  }
}

class ConstClass {
  public static final String HELLO = "hello";

  static {
    System.out.println("ConstClass init!");
  }
}
