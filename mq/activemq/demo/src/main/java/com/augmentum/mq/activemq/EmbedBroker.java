package com.augmentum.mq.activemq;

import org.apache.activemq.broker.BrokerService;

/**
 * @author zack
 * @create 2019-10-04 20:03
 * @function
 */
public class EmbedBroker {

  public static void main(String[] args) {
    //
      BrokerService brokerService = new BrokerService();
      brokerService.setUseJmx(true);
      try {
          // if would this to work, shoud add dependency of 'activemq-all'
          brokerService.addConnector("tcp://localhost:61616");
          brokerService.start();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
