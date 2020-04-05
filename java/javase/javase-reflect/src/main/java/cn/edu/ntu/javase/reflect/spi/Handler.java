package cn.edu.ntu.javase.reflect.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 假定, 现有个场景, 需要对消息进行处理, <br>
 *      但消息处理器的实现需要放开, 及可以动态的对处理器进行加载, <br>
 *      当有新消息到达时, 依次调用处理器对消息进行处理, <br>
 *      让我们结合SPI和反射构造一个简单的 Plugin 系统 <br>
 *
 * @author zack <br>
 * @create 2020-02-10 23:21 <br>
 */
public interface Handler {
    Logger LOG = LoggerFactory.getLogger(Handler.class);

    void handle(String msg);
}
