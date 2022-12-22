package cn.edu.ntu.proxy.dynamic.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zack <br>
 * @create 2022-12-22 20:12 <br>
 * @project javas-jhm <br>
 */
@Slf4j
public class CglibCalculatorProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {

        log.info("The method {} begins with: {}", method.getName(), objects);
        Object result = methodProxy.invokeSuper(o, objects);
        log.info("The method {} ends with: {}", method.getName(), result);

        return result;
    }
}
