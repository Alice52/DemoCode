package cn.edu.ntu.mq.rabbitmq.publishsubscribe;

import cn.edu.ntu.mq.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-07-28 15:44
 * @function
 */
public class HeaderReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(HeaderReceiver.class);
    private static Connection connection = ConnectionUtils.getConnection();
}
