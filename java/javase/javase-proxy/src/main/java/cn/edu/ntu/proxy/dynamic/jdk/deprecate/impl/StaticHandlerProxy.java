package cn.edu.ntu.proxy.dynamic.jdk.deprecate.impl;

import cn.edu.ntu.proxy.dynamic.jdk.deprecate.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 23:53 <br>
 */
public class StaticHandlerProxy implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(StaticHandlerProxy.class);

    private final Handler handler;

    public StaticHandlerProxy(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(String data) {
        long start = System.currentTimeMillis();
        this.handler.handle(data);
        long end = System.currentTimeMillis();
        LOG.info("cost " + (end - start) + " ms");
    }
}
