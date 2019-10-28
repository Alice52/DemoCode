package cn.edu.ntu.spring.aop.before;

import cn.edu.ntu.spring.aop.before.impl.ArithmeticCalculatorImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zack
 * @create 2019-10-28 21:31
 * @function
 */
public class TestArithmeticCalculator {
  private ArithmeticCalculator calculator;

  @Before
  public void init() {
    calculator = new ArithmeticCalculatorImpl();
  }

  @Test
  public void testAdd() {
    calculator.add(2, 3);
  }
}
