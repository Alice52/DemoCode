package cn.edu.ntu.javaee.annotation.usage.before;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2020-05-01 12:17 <br>
 */
@Slf4j
public class ArithmeticCalculatorImpl implements IArithmeticCalculator {

  @Override
  public int add(int a, int b) {
    log.info("The method add begins with [" + a + ", " + b + "]");
    int result = a + b;
    log.info("The method add ends with [" + result + "]");
    return result;
  }

  @Override
  public int sub(int a, int b) {
    log.info("The method sub begins with [" + a + ", " + b + "]");
    int result = a - b;
    log.info("The method sub ends with [" + result + "]");
    return result;
  }

  @Override
  public int mul(int a, int b) {
    log.info("The method mul begins with [" + a + ", " + b + "]");
    int result = a * b;
    log.info("The method mul ends with [" + result + "]");
    return result;
  }

  @Override
  public int div(int a, int b) {
    log.info("The method div begins with [" + a + ", " + b + "]");
    int result = a / b;
    log.info("The method div ends with [" + result + "]");
    return result;
  }
}
