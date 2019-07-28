package com.augmentum.rabbitmq;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-07-27 22:38
 * @function
 */
public class TestSL4J {
    private static final Logger LOG = LoggerFactory.getLogger(TestSL4J.class);

    @Test
    public void testSL4J() {

        LOG.info("info");
        LOG.warn("warn");
        LOG.error("error");
        LOG.debug("debug");
    }
}
