package cn.edu.ntu.mq.rabbitmq.publishsubscribe;

import cn.edu.ntu.mq.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
