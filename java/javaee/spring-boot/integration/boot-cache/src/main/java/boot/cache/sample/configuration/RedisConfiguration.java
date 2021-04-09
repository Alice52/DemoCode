package boot.cache.sample.configuration;

import boot.cache.sample.constants.GlobalCacheConstants;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-04-09 12:17 <br>
 * @project integration <br>
 */
@Configuration
public class RedisConfiguration {
  /**
   * 可以在这里指定某个 key 的过期时间
   *
   * @return
   */
  @Bean
  RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
    return builder -> {
      Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
      configurationMap.put(
          GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY,
          RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10)));
      builder.withInitialCacheConfigurations(configurationMap);
    };
  }
}
