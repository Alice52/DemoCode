package com.augmentum;

/**
 * @author zack
 * @create 2019-07-28 1:10
 * @function
 */
public class Constants {
    // 日志跟踪id名
    public static final String LOG_TRACE_ID = "traceid";

    //请求头跟踪id名
    public static final String HTTP_HEADER_TRACE_ID = "app_trace_id";


    public final static String SIMPLE_QUEUE_NAME  = "simple_queue";
    public static final String SIMPLE_QUEUE_MESSAGE = "hello simple queue";
    public static final String WORK_QUEUE_NAME = "task_queue";
    public static final String WORK_QUEUE_MESSAGE = "hello work queue.";

    public static final String EXCHANGE_LOG_NAME = "log_exchange";
    public static final String WPUBLISH_QUEUE_MESSAGE = "info: Hello World!";
    public static final String EXCHANGE_DIRECT_NAME = "log_deirect_exchange";
    public static final String EXCHANGE_TOPICS_NAME = "log_topics_exchange" ;
    public static final String ROUTING_DIRECT_KEY = "directKey";
    public static final String RPC_QUEUE_NAME = "rpc_queue";


    public static final String QUEUE_DIRECT_NAME = "queue_direct";
    public static final String ROUTING_KEY_DIRECT = "routing_key_direct";
}
