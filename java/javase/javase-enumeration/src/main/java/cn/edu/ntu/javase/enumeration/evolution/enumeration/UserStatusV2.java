package cn.edu.ntu.javase.enumeration.evolution.enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-01-31 17:55 <br>
 */
public enum UserStatusV2 {
  /** now name is ENABLE */
  ENABLE("可用"),
  /** now name is DISABLE */
  DISABLE("禁用");

  private static final Logger LOG = LoggerFactory.getLogger(UserStatusV2.class);
  private final String desc;

  UserStatusV2(String desc) {
    this.desc = desc;
  }

  public static void main(String... args) {
    LOG.info(ENABLE.name());
    LOG.info(String.valueOf(DISABLE.ordinal()));
    LOG.info(ENABLE.getDesc());
  }

  public String getDesc() {
    return this.desc;
  }

  @Override
  public String toString() {
    return "UserStatusV2{" + "desc='" + desc + '\'' + '}';
  }
}
