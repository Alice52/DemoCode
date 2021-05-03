package boot.cache.lock.distibute.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2021-01-04 21:38 <br>
 * @project springboot <br>
 */
@Component
public class RedissonConfiguration {

    @Value(("${spring.redis.host}"))
    private String ip;

    @Value(("${spring.redis.port}"))
    private int port;

    @Value(("${spring.redis.password}"))
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + ip + ":" + port).setPassword(password);
        return Redisson.create(config);
    }
}
