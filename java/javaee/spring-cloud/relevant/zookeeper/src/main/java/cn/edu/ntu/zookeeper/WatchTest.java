package cn.edu.ntu.zookeeper;

import cn.edu.ntu.zookeeper.constants.Constants;
import lombok.SneakyThrows;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * watch strategy: <br>
 * 1. once <br>
 * 2. always <br>
 *
 * @author zack <br>
 * @create 2020-03-29 13:59 <br>
 */
public class WatchTest {
    private static final Logger LOG = LoggerFactory.getLogger(WatchTest.class);

    private static ZooKeeper zooKeeper;

    @SneakyThrows
    private static ZooKeeper startZK() {
        zooKeeper =
                new ZooKeeper(
                        Constants.ZOOKEEPER_SERVICE,
                        Constants.SESSION_TIME_OUT,
                        event -> LOG.info("start zookeeper."));

        return zooKeeper;
    }

    @Deprecated
    public static String getData(String path) throws Exception {

        final String[] data = new String[1];

        Optional.ofNullable(zooKeeper.exists(path, false))
                .ifPresent(
                        x -> {
                            try {
                                String dataValue =
                                        new String(zooKeeper.getData(path, false, new Stat()));
                                LOG.info(dataValue);
                                data[0] = dataValue;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

        return data[0];
    }

    @Test
    public void testOnce() throws Exception {
        WatchTest.startZK();
        WatchTest.getData(Constants.PATH);

        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }

    public String get(String path) {

        String data = null;

        try {
            Stat stat =
                    Optional.ofNullable(zooKeeper)
                            .orElseGet(WatchTest::startZK)
                            .exists(path, false);
            boolean equals = Optional.ofNullable(stat).equals(Optional.empty());
            if (equals) {
                LOG.info("{} is not exist.", path);
            }

            // if znode is not exist will throw exception
            data = new String(zooKeeper.getData(path, event -> get(path), new Stat()));
        } catch (Exception e) {
            LOG.error("Get zookeeper info failed: {}", e);
        }
        LOG.info("{} value: {}", path, data);
        return data;
    }

    @Test
    public void testMore() throws Exception {
        WatchTest once = new WatchTest();
        once.get(Constants.PATH);
        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }
}
