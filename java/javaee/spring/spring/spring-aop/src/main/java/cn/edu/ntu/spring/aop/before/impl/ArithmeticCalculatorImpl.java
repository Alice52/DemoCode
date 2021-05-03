package cn.edu.ntu.spring.aop.before.impl;

import cn.edu.ntu.spring.aop.before.ArithmeticCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-10-28 21:19
 * @function
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(ArithmeticCalculator.class);

    @Override
    public int add(int a, int b) {
        LOG.info("The method add begins with [" + a + ", " + b + "]");
        int result = a + b;
        LOG.info("The method add ends with [" + result + "]");
        return result;
    }

    @Override
    public int sub(int a, int b) {
        LOG.info("The method sub begins with [" + a + ", " + b + "]");
        int result = a - b;
        LOG.info("The method sub ends with [" + result + "]");
        return result;
    }

    @Override
    public int mul(int a, int b) {
        LOG.info("The method mul begins with [" + a + ", " + b + "]");
        int result = a * b;
        LOG.info("The method mul ends with [" + result + "]");
        return result;
    }

    @Override
    public int div(int a, int b) {
        LOG.info("The method div begins with [" + a + ", " + b + "]");
        int result = a / b;
        LOG.info("The method div ends with [" + result + "]");
        return result;
    }
}
