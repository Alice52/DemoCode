package com.augmentum.mq.activemq.utils;

import com.augmentum.mq.activemq.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

/**
 * @author zack
 * @create 2019-10-03 11:04
 * @function
 */
public class ActiveMQUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMQUtil.class);
  private static Connection connection;

  /**
   * @notice This connection should be singleton, and all lifecycle just has one connection. And can
   *     reference Rabbitmq[esb].
   * @return
   */
  public static Connection getConnection() {
    // 1. create connection factory
    ActiveMQConnectionFactory activeMQConnectionFactory =
        new ActiveMQConnectionFactory(Constants.ACTIVEMQ_URL);
    Connection connection = null;
    // 2. create connection
    try {
      connection = activeMQConnectionFactory.createConnection();
    } catch (JMSException e) {
      LOGGER.warn("Get connection failed: {}", e);
    }

    return connection;
  }

  public static Connection getConnection(String url) {
    // 1. create connection factory
    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
    Connection connection = null;
    // 2. create connection
    try {
      connection = activeMQConnectionFactory.createConnection();
    } catch (JMSException e) {
      LOGGER.warn("Get connection failed: {}", e);
    }

    LOGGER.info("create connection success.");
    return connection;
  }

  public static Session getSession(boolean transacted, int acknowledgeMode) {
    connection = ActiveMQUtil.getConnection();
    Session session = null;
    try {
      connection.start();
      session = connection.createSession(transacted, acknowledgeMode);
    } catch (JMSException e) {
      LOGGER.warn("Create Session failed: {}", e);
    }
    LOGGER.info("create session success.");
    return session;
  }

  public static void getSession(Session session) {

    try {
      session.close();
    } catch (JMSException e) {
      LOGGER.warn("Close Session failed: {}", e);
    }
  }
}
