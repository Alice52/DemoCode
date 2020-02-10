package cn.edu.ntu.javase.reflect.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-02-10 23:21 <br>
 */
public class HandlerImpl1 implements Handler {
  private static final Logger LOG = LoggerFactory.getLogger(HandlerImpl1.class);

  @Override
  public void handle(String msg) {
    LOG.info("HandlerImpl1:" + msg);
  }
}
