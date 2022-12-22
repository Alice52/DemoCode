package cn.edu.ntu.proxy.dynamic.jdk;

import cn.edu.ntu.proxy.Calculator;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zack <br>
 * @create 2022-12-22 20:07 <br>
 * @project javas-jhm <br>
 */
@Slf4j
public class JdkCalculatorProxy {

    public static Calculator getProxy(Calculator calculator) {

        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h =
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        Object result = null;
                        try {
                            log.info("The method {} begins with: {}", method.getName(), args);
                            result = method.invoke(calculator, args);
                            log.info("The method {} ends with: {}", method.getName(), result);
                        } catch (Exception e) {
                        } finally {
                        }
                        return result;
                    }
                };

        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;
    }
}
