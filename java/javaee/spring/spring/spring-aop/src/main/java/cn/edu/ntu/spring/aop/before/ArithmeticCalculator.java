package cn.edu.ntu.spring.aop.before;

/**
 * @author zack
 * @create 2019-10-28 21:19
 * @function test for aop log
 */
public interface ArithmeticCalculator {

    default int add(int a, int b) {
        return a + b;
    }

    default int sub(int a, int b) {
        return a - b;
    }

    default int mul(int a, int b) {
        return a * b;
    }

    default int div(int a, int b) {
        return a / b;
    }
}
