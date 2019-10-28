package cn.edu.ntu.spring.aop.before.proxy;

import cn.edu.ntu.spring.aop.before.ArithmeticCalculator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zack
 * @create 2019-10-28 22:25
 * @function
 */
public class TestCalculatorProxy {
  private ArithmeticCalculator calculatorProxy;

  @Before
  public void init() {
    calculatorProxy =
        (ArithmeticCalculator)
            new ArithmeticCalculatorProxy(new ArithmeticCalculatorImpl()).getProxy();
  }

  @Test
  public void testCalculatorProxy() {
    calculatorProxy.add(1, 3);
  }
}
