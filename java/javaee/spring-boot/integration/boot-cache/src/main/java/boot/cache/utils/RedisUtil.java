package boot.cache.utils;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-01-05 21:14 <br>
 * @project springboot <br>
 */
@Slf4j
@Component
public class RedisUtil {

  @Resource RedisTemplate redisTemplate;

  public <E> E get(String realKey) {

    Object object = redisTemplate.opsForValue().get(realKey);

    if (ObjectUtil.isNotNull(object)) {
      E e = null;
      try {
        e = (E) object;
      } catch (Exception ex) {
        log.warn("cast object: {} to type: {} error: {}", object, e.getClass(), ex);
      }

      return e;
    }

    return null;
  }

  public void set(Object obj, String realKey, final long timeout, final TimeUnit unit) {
    Optional.ofNullable(obj)
        .ifPresent(x -> redisTemplate.opsForValue().set(realKey, obj, timeout, unit));
  }
}
