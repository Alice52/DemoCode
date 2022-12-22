package cn.edu.ntu.proxy.dynamic.jdk.deprecate.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zack <br>
 * @create 2020-04-04 23:53 <br>
 */
public class HandlerInvocation implements InvocationHandler {
    private static final Logger LOG = LoggerFactory.getLogger(HandlerInvocation.class);

    private final Object target;

    public HandlerInvocation(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 代理对象
     * @param method 对应于在代理对象上调用的接口方法的 Method instance
     * @param args 代理对象调用接口方法时传递的实际参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOG.info("call method " + method + " ,args " + args);
        long start = System.currentTimeMillis();
        try {
            return method.invoke(this.target, args);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("cost " + (end - start) + "ms");
        }
    }
}
