package boot.cache.lock.local.service;

import boot.cache.lock.utils.RedisUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zack <br>
 * @create 2021-01-05 21:06 <br>
 * @project springboot <br>
 */
@Slf4j
@Service
public class LocalLockService implements ILocalLockService {
  private static final String BRANDS_KEY = "BRANDS";
  private static final String REDIS_LOCK_KEY = "LOCK";
  @Resource RedisUtil redisUtil;
  @Autowired StringRedisTemplate redisTemplate;
  private Lock lock = new ReentrantLock();

  @Override
  public Map getAllBrands() {
    Map brands = redisUtil.get(BRANDS_KEY);
    if (ObjectUtil.isNull(brands)) {
      // brands = getBrandsFromDB();
      // brands = getBrandsFromDBLockBySynchronized();
      // brands = getBrandsFromDBLockByLock();
      brands = getFromDbWithDistributeLockV4();
    }

    return brands;
  }

  /**
   * 大并发下, 会有多个请求的线程进入查数据库的方法.
   *
   * @return
   */
  private Map getBrandsFromDB() {
    Map brands = redisUtil.get(BRANDS_KEY);
    ;
    if (ObjectUtil.isNull(brands)) {
      brands = getFromDB();
      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
    }

    return brands;
  }

  /**
   * Synchronized(this): this is singleton, so it can only one thread can run at same time.<br>
   * And can only work in standalone deploy. <br>
   *
   * <pre>
   *     1. Notice please make atomic of
   *        - query from redis cache
   *        - query database
   *        - put result to redis cache.
   * </pre>
   *
   * @return
   */
  private Map getBrandsFromDBLockBySynchronized() {
    Map brands;
    // 大并发下所有线程的都在这里排队竞争
    synchronized (this) {
      // 所以进来要再查一下缓存
      brands = redisUtil.get(BRANDS_KEY);
      if (ObjectUtil.isNull(brands)) {
        brands = getFromDB();
        redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
      }
    }

    return brands;
  }

  private Map getBrandsFromDBLockByLock() {
    Map brands;
    // 大并发下所有线程的都在这里排队竞争
    lock.lock();
    try {
      // 所以进来要再查一下缓存
      brands = redisUtil.get(BRANDS_KEY);
      if (ObjectUtil.isNull(brands)) {
        brands = getFromDB();
        redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
      }
    } finally {
      lock.unlock();
    }

    return brands;
  }

  /**
   *
   *
   * <pre>
   *     1. 占到锁之后删除锁之前逻辑出来问题就会出现死锁
   *        - solution: 占分布式锁时设置过期时间
   * </pre>
   *
   * @return
   */
  @SneakyThrows
  private Map getFromDbWithDistributeLockV1() {
    // 1. 占分布式锁:
    Boolean lock = redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK_KEY, "lock-value");
    if (lock) {
      Map brands = getFromDB();
      // 2. set redis value
      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
      // 3. 删除分布式锁
      redisTemplate.delete(REDIS_LOCK_KEY);
      return brands;
    }

    TimeUnit.MINUTES.sleep(100);
    return getFromDbWithDistributeLockV1();
  }

  /**
   *
   *
   * <pre>
   *     1. 占分布式锁时加过期时间, 且时原子的操作
   *     2. issue
   *         - 如果业务逻辑超长, 自己设置的 redis Key 已经过期了, 业务逻辑执行完之后有可能把别人正在持有的锁删掉
   *         - solution:
   *              1. 占分布式锁时的 Value 指定为 UUID, 只能删除自己的锁
   *              2. 如果业务逻辑超长则锁自动续期: 可以这是一个较大的时间
   * </pre>
   *
   * @return
   */
  @SneakyThrows
  private Map getFromDbWithDistributeLockV2() {
    // 1. 占分布式锁:
    Boolean lock =
        redisTemplate
            .opsForValue()
            .setIfAbsent(REDIS_LOCK_KEY, "lock-value", 300, TimeUnit.SECONDS);
    if (lock) {
      Map brands = getFromDB();
      // 2. set redis value
      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
      // 3. 删除分布式锁
      redisTemplate.delete(REDIS_LOCK_KEY);
      return brands;
    }

    TimeUnit.MINUTES.sleep(100);
    return getFromDbWithDistributeLockV2();
  }

  /**
   *
   *
   * <pre>
   *     1. 只能删除自己的锁
   *     2. 删除锁还是有问题: 还是有可能删除别人持有的锁
   *        - root cause: 获取锁时到删除锁的时间间隔
   *        - solution: 使删除锁也是原子的
   * </pre>
   *
   * @return
   */
  @SneakyThrows
  private Map getFromDbWithDistributeLockV3() {
    // 1. 占分布式锁:
    String uuid = UUID.fastUUID().toString();
    Boolean lock =
        redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK_KEY, uuid, 300, TimeUnit.SECONDS);
    if (lock) {
      Map brands = getFromDB();
      // 2. set redis value
      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
      // 3. 删除分布式锁: 只能删除自己的锁
      String latestUuid = redisUtil.get(REDIS_LOCK_KEY);
      if (latestUuid.equals(uuid)) {
        redisTemplate.delete(REDIS_LOCK_KEY);
      }

      return brands;
    }

    TimeUnit.MINUTES.sleep(100);
    return getFromDbWithDistributeLockV3();
  }

  /**
   *
   *
   * <pre>
   *     1. 删除锁的操作时原子的
   * </pre>
   *
   * @return
   */
  @SneakyThrows
  private Map getFromDbWithDistributeLockV4() {
    // 1. 占分布式锁:
    String uuid = UUID.fastUUID().toString();
    Boolean lock =
        redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK_KEY, uuid, 30, TimeUnit.SECONDS);
    if (lock) {
      Map brands = getFromDB();
      // 2. set redis value
      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
      // 3. 删除分布式锁: 只能删除自己的锁, 且原子
      String script =
          "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
      DefaultRedisScript<Object> defaultRedisScript =
          new DefaultRedisScript<>(script, Object.class);
      Object delete =
          redisTemplate.execute(defaultRedisScript, Arrays.asList(REDIS_LOCK_KEY), uuid);

      return brands;
    }

    TimeUnit.MINUTES.sleep(100);
    return getFromDbWithDistributeLockV4();
  }

  /**
   * Query core logic.
   *
   * @return
   */
  private Map getFromDB() {
    log.info("query database.");
    Map brands = new HashMap(1);
    brands.put("zack", 18);
    return brands;
  }
}
