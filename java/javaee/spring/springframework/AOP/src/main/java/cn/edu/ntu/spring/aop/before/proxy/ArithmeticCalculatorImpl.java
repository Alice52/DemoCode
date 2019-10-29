package cn.edu.ntu.spring.aop.before.proxy;

import cn.edu.ntu.spring.aop.before.ArithmeticCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zack
 * @create 2019-10-28 21:19
 * @function
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());


  @Override
  public int add(int a, int b) {
    int result = a + b;
    return result;
  }

  @Override
  public int sub(int a, int b) {
    int result = a - b;
    return result;
  }

  @Override
  public int mul(int a, int b) {
    int result = a * b;
    return result;
  }

  @Override
  public int div(int a, int b) {
    int result = a / b;
    return result;
  }
}
