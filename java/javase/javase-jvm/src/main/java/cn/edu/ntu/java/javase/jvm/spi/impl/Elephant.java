package cn.edu.ntu.java.javase.jvm.spi.impl;

import cn.edu.ntu.java.javase.jvm.spi.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 23:51 <br>
 */
public class Elephant implements Animal {
    private static final Logger LOG = LoggerFactory.getLogger(Elephant.class);

    @Override
    public String getType() {
        final String name = "Elephant";
        LOG.info("get animal type: {}", name);
        return name;
    }
}
