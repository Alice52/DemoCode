package cn.edu.ntu.javaee.annotation.usage.before;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zack
 * @create 2019-10-28 21:31
 * @function
 */
public class ArithmeticCalculatorTest {
  private IArithmeticCalculator calculator;

  @Before
  public void init() {
    calculator = new ArithmeticCalculatorImpl();
  }

  @Test
  public void testAdd() {
    calculator.add(2, 3);
  }
}
