package boot.cache.lock.local.controller;

import boot.cache.lock.model.User;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * TODO: this {@link io.netty.util.internal.OutOfDirectMemoryError } cannot re-produce due to low
 * through out.
 *
 * @author zack <br>
 * @create 2021-01-04 22:09 <br>
 * @project springboot <br>
 */
@RestController
@RequestMapping("/cache")
public class OutOfMemoryController {

  @Resource RedisTemplate redisTemplate;

  @GetMapping("/brands")
  public Object getListOfBrand() {

    Object usersFromRedis = redisTemplate.opsForValue().get("omm-key");
    if (ObjectUtil.isNull(usersFromRedis)) {
      usersFromRedis = generateMap();
      redisTemplate
          .opsForValue()
          .set("omm-key", JSONUtil.toJsonStr(usersFromRedis), 2, TimeUnit.HOURS);
    }

    return usersFromRedis;
  }

  private Map generateMap() {
    Stream<Integer> range = Stream.generate(() -> (int) (Math.random() * 100)).limit(1000);
    List<User> users = new ArrayList<>();
    range.forEach(x -> users.add(new User("zack" + x, x)));

    return new HashMap<String, Object>() {
      {
        put("oom-key", users);
      }
    };
  }
}
