package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 15:43
 * @function
 */
public class HeaderSender {

    private static final Logger LOG = LoggerFactory.getLogger(HeaderSender.class);
    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {

    }
}
