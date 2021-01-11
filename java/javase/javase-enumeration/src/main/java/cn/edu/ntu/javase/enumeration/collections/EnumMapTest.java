package cn.edu.ntu.javase.enumeration.collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.Map;

/**
 * - EnumMap is special Map, and it's key should be enum object. <br>
 * - EnumMap implements by array[ordinal] internally, to improve operation speed. <br>
 *
 * @author zack <br>
 * @create 2020-01-31 18:40 <br>
 */
public class EnumMapTest {
  private static final Logger LOG = LoggerFactory.getLogger(EnumMapTest.class);

  @Test
  public void test() {
    Map<UserStatus, String> welcomeMap = new EnumMap<>(UserStatus.class);
    welcomeMap.put(UserStatus.A1, "hello");
    LOG.info(welcomeMap.toString());
  }
}
