package cn.edu.ntu.mq.constants;

/**
 * @author zack <br>
 * @create 2020-04-05 18:27 <br>
 */
public final class Constants {
  // active mq
  public static final String TCP_ACTIVEMQ_URL = "tcp://101.37.174.197:61616";
  public static final String NIO_ACTIVEMQ_URL = "nio://101.37.174.197:61613";
  public static final String BROKER_ACTIVEMQ_URL = "tcp://localhost:61616";

  public static final String QUEUE_NAME = "p2p_queue";
  public static final String TOPIC_NAME = "sub_topic";

  // rabbit mq
  public static final String LOG_TRACE_ID = "traceid";
  // 请求头跟踪id名
  public static final String HTTP_HEADER_TRACE_ID = "app_trace_id";

  public static final String SIMPLE_QUEUE_NAME = "simple_queue";
  public static final String SIMPLE_QUEUE_MESSAGE = "hello simple queue";
  public static final String WORK_QUEUE_NAME = "task_queue";
  public static final String WORK_QUEUE_MESSAGE = "hello work queue.";

  public static final String EXCHANGE_LOG_NAME = "log_exchange";
  public static final String WPUBLISH_QUEUE_MESSAGE = "info: Hello World!";
  public static final String EXCHANGE_DIRECT_NAME = "log_deirect_exchange";
  public static final String EXCHANGE_TOPICS_NAME = "log_topics_exchange";
  public static final String ROUTING_DIRECT_KEY = "directKey";
  public static final String RPC_QUEUE_NAME = "rpc_queue";

  public static final String QUEUE_DIRECT_NAME = "queue_direct";
  public static final String ROUTING_KEY_DIRECT = "routing_key_direct";
}
