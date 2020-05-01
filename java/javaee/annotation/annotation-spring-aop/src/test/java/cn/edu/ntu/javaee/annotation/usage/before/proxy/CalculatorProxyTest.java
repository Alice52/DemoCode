package cn.edu.ntu.javaee.annotation.usage.before.proxy;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zack
 * @create 2019-10-28 22:25
 * @function
 */
public class CalculatorProxyTest {
  private IArithmeticCalculator calculatorProxy;

  @Before
  public void init() {
    calculatorProxy =
        (IArithmeticCalculator)
            new ArithmeticCalculatorProxy(new ArithmeticCalculatorImpl()).getProxy();
  }

  @Test
  public void testCalculatorProxy() {
    calculatorProxy.mul(1, 3);
  }
}
