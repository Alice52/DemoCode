package cn.edu.ntu.mq.rabbitmq.direct_nosub;

import cn.edu.ntu.mq.rabbitmq.publishsubscribe.DirectReceiver;

/**
 * @author zack
 * @create 2019-09-15 21:35
 * @function
 */
public class DR {

    public static void main(String[] args) {
        cn.edu.ntu.mq.rabbitmq.publishsubscribe.DirectReceiver directReceiver =
                new DirectReceiver();
        directReceiver.receiveMsg();
    }
}
