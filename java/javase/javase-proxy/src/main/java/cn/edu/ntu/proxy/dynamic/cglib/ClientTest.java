package cn.edu.ntu.proxy.dynamic.cglib;

import cn.edu.ntu.proxy.CalculatorImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author zack <br>
 * @create 2022-12-22 20:01 <br>
 * @project javas-jhm <br>
 */
@Slf4j
public class ClientTest {

    public static void main(String[] args) {

        CglibCalculatorProxy proxy = new CglibCalculatorProxy();
        // 动态代理创建的class文件存储到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\code");
        // 通过cglib动态代理获取代理对象的过程，创建调用的对象,在后续创建过程中EnhanceKey的对象
        // 所以在进行enhancer对象创建的时候需要把EnhancerKey（newInstance）对象准备好,恰好这个对象也需要动态代理来生成
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(CalculatorImpl.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibCalculatorProxy());
        // 创建代理对象
        CalculatorImpl myCalculator = (CalculatorImpl) enhancer.create();
        // 通过代理对象调用目标方法
        myCalculator.add(1, 1);
        System.out.println(myCalculator.getClass());
    }
}
