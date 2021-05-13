package cn.edu.ntu.javaee.springmvc.servlet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-05-03 17:25 <br>
 */
public interface IHelloService {
    Logger LOG = LoggerFactory.getLogger(IHelloService.class);

    /** interface */
    default void say() {
        LOG.info("IHelloService say()");
    }
}
