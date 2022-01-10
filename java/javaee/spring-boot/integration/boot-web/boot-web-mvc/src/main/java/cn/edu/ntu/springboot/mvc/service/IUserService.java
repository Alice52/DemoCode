package cn.edu.ntu.springboot.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-09-08 20:37 <br>
 * @project spring <br>
 */
public interface IUserService {
    Logger LOG = LoggerFactory.getLogger(IUserService.class);

    default void helloWorld() {
        LOG.info("IUserService default impl");
    }
}
