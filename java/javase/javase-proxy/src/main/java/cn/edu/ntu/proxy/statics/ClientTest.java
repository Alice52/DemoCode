package cn.edu.ntu.proxy.statics;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2022-12-22 20:01 <br>
 * @project javas-jhm <br>
 */
@Slf4j
public class ClientTest {

    public static void main(String[] args) {
        CalculatorProxy proxy = new CalculatorProxy();
        proxy.add(1, 1);
        log.info("{}", proxy.getClass());
    }
}
