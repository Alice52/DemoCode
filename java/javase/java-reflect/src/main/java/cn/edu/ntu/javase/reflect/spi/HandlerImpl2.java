package cn.edu.ntu.javase.reflect.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-02-10 23:22 <br>
 */
public class HandlerImpl2 implements Handler {
  private static final Logger LOG = LoggerFactory.getLogger(HandlerImpl2.class);

  @Override
  public void handle(String msg) {
    LOG.info("HandlerImpl2:" + msg);
  }
}
