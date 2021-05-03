package cn.edu.ntu.mq.rabbitmq.rpc;

import cn.edu.ntu.mq.constants.Constants;
import cn.edu.ntu.mq.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-07-28 15:57
 * @function
 */
public class RPCReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(RPCReceiver.class);
    private static Connection connection = ConnectionUtils.getConnection();

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] argv) throws Exception {

        Channel channel = connection.createChannel();

        channel.queueDeclare(Constants.RPC_QUEUE_NAME, false, false, false, null);
        channel.queuePurge(Constants.RPC_QUEUE_NAME);

        // Fair dispatch
        channel.basicQos(1);

        LOG.info(" [x] Awaiting RPC requests");

        Object monitor = new Object();
        DeliverCallback deliverCallback =
                (consumerTag, delivery) -> {
                    AMQP.BasicProperties replyProps =
                            new AMQP.BasicProperties.Builder()
                                    .correlationId(delivery.getProperties().getCorrelationId())
                                    .build();
                    String response = "";
                    try {
                        String message = new String(delivery.getBody(), "UTF-8");
                        int n = Integer.parseInt(message);

                        LOG.info(" [.] fib(" + message + ")");
                        response += fib(n);
                    } catch (RuntimeException e) {
                        LOG.error(" [.] " + e.toString());
                    } finally {
                        channel.basicPublish(
                                "",
                                delivery.getProperties().getReplyTo(),
                                replyProps,
                                response.getBytes("UTF-8"));
                        channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                        // RabbitMq consumer worker thread notifies the RPC server owner thread
                        synchronized (monitor) {
                            monitor.notify();
                        }
                    }
                };

        channel.basicConsume(Constants.RPC_QUEUE_NAME, false, deliverCallback, (consumerTag -> {}));
        // Wait and be prepared to consume the message from RPC client.
        while (true) {
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
