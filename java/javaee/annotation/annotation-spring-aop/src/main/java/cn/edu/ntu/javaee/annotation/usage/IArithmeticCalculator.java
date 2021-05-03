package cn.edu.ntu.javaee.annotation.usage;

/**
 * @author zack <br>
 * @create 2020-05-01 12:16 <br>
 */
public interface IArithmeticCalculator {
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
