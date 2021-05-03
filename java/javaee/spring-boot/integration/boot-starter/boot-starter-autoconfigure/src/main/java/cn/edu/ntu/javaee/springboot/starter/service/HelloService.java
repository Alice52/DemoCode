package cn.edu.ntu.javaee.springboot.starter.service;

import cn.edu.ntu.javaee.springboot.starter.properties.HelloProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-17 16:35 <br>
 * @project springboot <br>
 */
@Service
public class HelloService {

    @Resource HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHellAtguigu(String name) {
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();
    }
}
