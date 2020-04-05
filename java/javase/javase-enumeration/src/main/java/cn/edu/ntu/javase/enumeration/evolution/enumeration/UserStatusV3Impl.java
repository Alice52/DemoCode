package cn.edu.ntu.javase.enumeration.evolution.enumeration;

import cn.edu.ntu.javase.enumeration.evolution.inter.CodeBasedEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-01-31 18:05 <br>
 */
public enum UserStatusV3Impl implements CodeBasedEnum {
  /** arg code is no relative with ordinal */
  ENABLE(1) {
    @Override
    public int code() {
      return 5;
    }
  },
  /** DISABLE: code = 10 */
  DISABLE(0) {
    @Override
    public int code() {
      return 10;
    }
  };

  private static final Logger LOG = LoggerFactory.getLogger(UserStatusV3Impl.class);

  private final int code;

  UserStatusV3Impl(int code) {
    this.code = code;
  }

  @Override
  public int code() {
    return this.code;
  }

  public static void main(String... arg) {
    LOG.info(ENABLE.name());
    LOG.info(String.valueOf(DISABLE.ordinal()));
    // 5
    LOG.info(String.valueOf(ENABLE.code()));
    // 10
    LOG.info(String.valueOf(DISABLE.code()));
  }
}
