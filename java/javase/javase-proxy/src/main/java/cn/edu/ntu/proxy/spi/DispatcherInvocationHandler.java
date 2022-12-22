package cn.edu.ntu.proxy.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Distribution Processor <br>
 * Forward the requests to the target one by one. <br>
 *
 * @author zack <br>
 * @create 2020-02-10 23:27 <br>
 */
public class DispatcherInvocationHandler implements InvocationHandler {
    private static final Logger LOG = LoggerFactory.getLogger(DispatcherInvocationHandler.class);
    private final List<Object> targets;

    public DispatcherInvocationHandler(List<Object> targets) {
        this.targets = targets;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object target : targets) {
            method.invoke(target, args);
        }
        return null;
    }
}
