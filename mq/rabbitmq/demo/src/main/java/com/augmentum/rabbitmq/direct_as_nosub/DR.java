package com.augmentum.rabbitmq.direct_as_nosub;

import com.augmentum.rabbitmq.publishsubscribe.DirectReceiver;

/**
 * @author zack
 * @create 2019-09-15 21:35
 * @function
 */
public class DR {

    public static void main(String[] args) {
        DirectReceiver directReceiver =  new DirectReceiver();
        directReceiver.receiveMsg();
    }
}
