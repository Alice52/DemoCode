package cn.edu.ntu.javase.jvm;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * -XX:+PrintGCDetails -Xmx10m -Xms10m -Xss1024k -XX:MetaspaceSize=1g -XX:+PrintCommandLineFlags
 * -XX:+UseSerialGC
 *
 * @author zack <br>
 * @create 2021-03-02 13:21 <br>
 * @project javase <br>
 */
@Slf4j
public class HelloGc {

  @SneakyThrows
  public static void main(String[] args) {

    log.info("HelloGc");

    long xms = Runtime.getRuntime().totalMemory();
    long xmx = Runtime.getRuntime().maxMemory();

    byte[] bytes = new byte[1024 * 1024 * 50];
    // TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
  }
}
