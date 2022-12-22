package cn.edu.ntu.proxy;

/**
 * @author zack <br>
 * @create 2022-12-22 17:16 <br>
 * @project javas-jhm <br>
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;
        return result;
    }

    @Override
    public int mult(int i, int j) {

        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;
        return result;
    }
}
