package cn.edu.ntu.javaee.springmvc.servlet.service.impl;

import cn.edu.ntu.javaee.springmvc.servlet.service.IHelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2020-05-03 17:26 <br>
 */
@Slf4j
public abstract class AbstractHelloService implements IHelloService {

    @Override
    public void say() {
        log.info("AbstractHelloService say()");
    }
}
