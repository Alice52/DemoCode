package cn.edu.ntu.javase.reflect.spi.impl;

import cn.edu.ntu.javase.reflect.spi.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 23:56 <br>
 */
public class HandlerImpl1 implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(HandlerImpl1.class);

    @Override
    public void handle(String msg) {
        LOG.info("HandlerImpl1:" + msg);
    }
}
