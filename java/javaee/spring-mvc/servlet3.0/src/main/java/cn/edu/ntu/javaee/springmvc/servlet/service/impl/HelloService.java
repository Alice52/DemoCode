package cn.edu.ntu.javaee.springmvc.servlet.service.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2020-05-03 17:29 <br>
 */
@Slf4j
public class HelloService extends AbstractHelloService {
    @Override
    public void say() {
        log.info("AbstractHelloService say()");
    }
}
