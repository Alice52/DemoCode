package cn.edu.ntu.proxy.dynamic.jdk;

import cn.edu.ntu.proxy.Calculator;
import cn.edu.ntu.proxy.CalculatorImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2022-12-22 20:01 <br>
 * @project javas-jhm <br>
 */
@Slf4j
public class ClientTest {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Calculator proxy = JdkCalculatorProxy.getProxy(new CalculatorImpl());
        proxy.add(1, 1);
        log.info("{}", proxy.getClass());
    }
}
