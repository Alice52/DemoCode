package cn.edu.ntu.zookeeper;

import cn.edu.ntu.zookeeper.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Optional;

import static cn.edu.ntu.zookeeper.constants.Constants.DATA;
import static cn.edu.ntu.zookeeper.constants.Constants.PATH;

/**
 * step: <br>
 * 1. get connection <br>
 * 2. create or open session <br>
 * 3. call api operation <br>
 * 4. close session and connection <br>
 * <br>
 * optimization: <br>
 * 1. should not deliver connection <br>
 * 2. scalability: common should be extra in base <br>
 * 3. use spring aspect + annotation: such as Pre-Advice, Post-Advice <br>
 * 4. use middleware: request coming in will auto establish connection, leave will auto close
 * connection <br>
 *
 * @author zack <br>
 * @create 2020-03-28 18:16 <br>
 */
@Slf4j
public class HelloZooKeeper {

  public static void main(String[] args) throws Exception {

    HelloZooKeeper helloZooKeeper = new HelloZooKeeper();
    ZooKeeper zooKeeper = helloZooKeeper.startZookeeper();

    if (zooKeeper.exists(PATH, false) == null) {
      helloZooKeeper.createZNode(zooKeeper, PATH, DATA);
    } else {
      log.info("this node already exists.");
    }

    String zNode = helloZooKeeper.getZNode(zooKeeper, PATH);
    log.info("Get {} value: {}", PATH, zNode);

    helloZooKeeper.stopZookeeper(zooKeeper);
  }

  private ZooKeeper startZookeeper() {

    try {
      return new ZooKeeper(
              Constants.ZOOKEEPER_SERVICE, Constants.SESSION_TIME_OUT, (event) -> log.info(event.toString()));
    } catch (IOException e) {
      log.error("Get Zookeeper connection failed from {}, and cause by: {}",  Constants.ZOOKEEPER_SERVICE, e);
    }

    return null;
  }

  private void createZNode(ZooKeeper zooKeeper, String path, String data)
      throws KeeperException, InterruptedException {

    zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
  }

  private String getZNode(ZooKeeper zooKeeper, String path)
      throws KeeperException, InterruptedException {

    return new String(zooKeeper.getData(path, false, new Stat()));
  }

  private void stopZookeeper(ZooKeeper zooKeeper) {

    Optional<ZooKeeper> zooKeeperOptional = Optional.ofNullable(zooKeeper);
    zooKeeperOptional.ifPresent(
        zooKeeper1 -> {
          try {
            zooKeeper1.close();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
  }
}
