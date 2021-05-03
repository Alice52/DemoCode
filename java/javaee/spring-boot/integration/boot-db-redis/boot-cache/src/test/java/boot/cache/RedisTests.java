package boot.cache;

import cn.hutool.core.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-01-04 21:48 <br>
 * @project springboot <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    private static final Logger LOG = LoggerFactory.getLogger(RedisTests.class);

    @Resource RedisTemplate redisTemplate;

    @Resource StringRedisTemplate stringRedisTemplate;

    @Test
    public void testAutoConfigBeans() {

        LOG.info("redisTemplate: {}", redisTemplate);
        LOG.info("stringRedisTemplate: {}", stringRedisTemplate);
    }

    @Test
    public void testSimpleUsage() {

        Object o = redisTemplate.opsForValue().get(this.getClass().getName());
        LOG.info("get from redisTemplate but not exist: {}", o);
        Assert.isNull(o);

        redisTemplate.opsForValue().set(this.getClass().getName(), this.getClass().getName());
        o = redisTemplate.opsForValue().get(this.getClass().getName());
        LOG.info("get from redisTemplate: {}", o);
        Assert.notNull(o);

        final Boolean delete = redisTemplate.delete(this.getClass().getName());
        LOG.info("delete from redisTemplate: {}", delete);
        Assert.isTrue(delete);
    }
}
