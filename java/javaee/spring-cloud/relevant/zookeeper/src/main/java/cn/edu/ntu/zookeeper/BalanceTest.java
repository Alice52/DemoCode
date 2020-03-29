package cn.edu.ntu.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * // TODO: no read
 *
 * @author zack <br>
 * @create 2020-03-29 16:22 <br>
 */
public class BalanceTest {
  private static final Logger LOG = LoggerFactory.getLogger(BalanceTest.class);
  private static final String CONNECTSTRING = "192.168.67.167:2181";
  private static final int SESSION_TIMEOUT = 50 * 1000;
  private static final String PATH = "/atguigu";
  private static final String SUB_PREFIX = "sub";
  private ZooKeeper zk = null;
  private int subCount = 5;
  private List<String> serviceNodeLists = new ArrayList<String>();
  private int serviceNum = 0;

  public ZooKeeper startZK() throws IOException {
    return new ZooKeeper(
        CONNECTSTRING,
        SESSION_TIMEOUT,
        new Watcher() {
          @Override
          public void process(WatchedEvent event) {
            try {
              serviceNodeLists = zk.getChildren(PATH, true);
            } catch (KeeperException | InterruptedException e) {
              e.printStackTrace();
            }
          }
        });
  }

  public String dealRequest() throws KeeperException, InterruptedException {
    serviceNum = serviceNum + 1;

    for (int i = serviceNum; i <= subCount; i++) {
      if (serviceNodeLists.contains(SUB_PREFIX + serviceNum)) {
        return new String(zk.getData(PATH + "/" + SUB_PREFIX + serviceNum, false, new Stat()));
      } else {
        serviceNum = serviceNum + 1;
      }
    }
    for (int i = 1; i <= subCount; i++) {
      if (serviceNodeLists.contains(SUB_PREFIX + i)) {
        serviceNum = i;
        return new String(zk.getData(PATH + "/" + SUB_PREFIX + serviceNum, false, new Stat()));
      }
    }
    return "null node~~~~~";
  }

  public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
    BalanceTest test = new BalanceTest();

    test.setZk(test.startZK());
    Thread.sleep(3000);
    String result = null;
    // 以轮询的方式访问15次，共计5个节点来应付实现负载均衡
    for (int i = 1; i <= 15; i++) {
      result = test.dealRequest();
      System.out.println("****loop:" + i + "\t" + test.serviceNum + "\t" + result);
      Thread.sleep(2000);
    }
  }

  public ZooKeeper getZk() {
    return zk;
  }

  public void setZk(ZooKeeper zk) {
    this.zk = zk;
  }
}
