package cn.edu.ntu.javase.reflect.proxy.impl;

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
