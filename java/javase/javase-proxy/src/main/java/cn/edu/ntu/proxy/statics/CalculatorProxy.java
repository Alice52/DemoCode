package cn.edu.ntu.proxy.statics;

import cn.edu.ntu.proxy.Calculator;
import cn.edu.ntu.proxy.CalculatorImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2022-12-22 19:55 <br>
 * @project javas-jhm <br>
 */
@Slf4j
public class CalculatorProxy implements Calculator {

    private Calculator calculator = new CalculatorImpl();

    @Override
    public int add(int a, int b) {
        log.info("The method add begins with [" + a + ", " + b + "]");
        int result = calculator.add(a, b);
        log.info("The method add ends with [" + result + "]");
        return result;
    }

    @Override
    public int sub(int a, int b) {
        log.info("The method sub begins with [" + a + ", " + b + "]");
        int result = calculator.sub(a, b);
        log.info("The method sub ends with [" + result + "]");
        return result;
    }

    @Override
    public int mult(int a, int b) {
        log.info("The method mul begins with [" + a + ", " + b + "]");
        int result = calculator.mult(a, b);
        log.info("The method mul ends with [" + result + "]");
        return result;
    }

    @Override
    public int div(int a, int b) {
        log.info("The method div begins with [" + a + ", " + b + "]");
        int result = calculator.div(a, b);
        log.info("The method div ends with [" + result + "]");
        return result;
    }
}
