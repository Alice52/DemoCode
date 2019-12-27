package com.augmentum.springboot.integration.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-12-25 22:43
 * @function custom exception
 */
public class UserNotExistException extends RuntimeException {
  private static final Logger LOG = LoggerFactory.getLogger(UserNotExistException.class);

  public UserNotExistException() {
    super("use not exist!");
    LOG.info("use not exist!");
  }
}
