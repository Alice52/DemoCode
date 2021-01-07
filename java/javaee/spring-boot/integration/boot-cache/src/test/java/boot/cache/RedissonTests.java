package boot.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-01-07<br>
 * @project integration <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTests {

  private static final Logger LOG = LoggerFactory.getLogger(RedissonTests.class);

  @Resource RedissonClient redissonClient;

  @Test
  public void testRedisson() {
    LOG.info("redissonClient: {}", redissonClient);
  }
}
