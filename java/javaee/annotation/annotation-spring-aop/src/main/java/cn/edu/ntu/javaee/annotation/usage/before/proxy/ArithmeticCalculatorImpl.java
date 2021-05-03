package cn.edu.ntu.javaee.annotation.usage.before.proxy;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zack
 * @create 2019-10-28 21:19
 * @function
 */
@Component
@Slf4j
public class ArithmeticCalculatorImpl implements IArithmeticCalculator {

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
