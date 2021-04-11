package boot.cache.lock.distibute.service;

import boot.cache.utils.RedisUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * <pre>
 *     1. getWithLock: lock
 *     2.
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-05 21:06 <br>
 * @project springboot <br>
 */
@Slf4j
@Service
public class DistributeLockService implements IDistributeLockService {
  private static final String BRANDS_KEY = "BRANDS";
  private static final String REDIS_DISTRIBUTE_LOCK_KEY = "DISTRIBUTE_LOCK";

  @Resource RedissonClient redissonClient;
  @Resource RedisUtil redisUtil;

  /**
   * 等 5 个班都锁门, 才可以锁学校大门
   *
   * <pre>
   *     1. getCountDownLatch Key 过期时间 -1
   *     2. latch count 为0, 最小值为 0
   *     3. getCountDownLatch 会阻塞, 直到count=0 时才执行
   * </pre>
   */
  @Override
  @SneakyThrows
  public void lockSchoolDoor() {

    RCountDownLatch latch = redissonClient.getCountDownLatch("door-lock");
    latch.trySetCount(5);
    latch.await();

    log.info("school door closing ...");
  }

  @Override
  public void lockDoor() {
    RCountDownLatch latch = redissonClient.getCountDownLatch("door-lock");
    latch.countDown(); // -1
    log.info("door closing ...");
  }

  /**
   * 停车场停车. <br>
   *
   * <pre>
   *    1. park 过期时间为 -1
   *    2. 当没有车位时, 停车动作会被阻塞, 直到有车离开[空出车位]
   *    3. 车离开没有限制
   * </pre>
   */
  @SneakyThrows
  @Override
  public void go() {
    RSemaphore park = redissonClient.getSemaphore("park");
    park.trySetPermits(5); // 5 个车位
    park.release(); // 走车
    park.acquire(); // 停车, 阻塞等待
    boolean acquire = park.tryAcquire(); // 停车, 能停就停, 不能停就算了
  }

  @Override
  public String readValue() {
    String uuid;
    RReadWriteLock lock = redissonClient.getReadWriteLock("rw-lock");
    lock.readLock().lock();
    try {
      uuid = redisUtil.get("wv");
    } finally {
      lock.readLock().unlock();
    }

    return uuid;
  }

  /**
   *
   *
   * <pre>
   *     1. 读写锁也会自动续期, 但是可以读到最新的数据[修改期间会阻塞所有操作]
   *          - 写 + 读: 等待写锁释放
   *          - 写 + 写: 阻塞写
   *          - 读 + 写: 等待写锁释放
   *          - 读 + 读: 无锁，只会记录所有的读锁, 都能加锁成功
   * </pre>
   *
   * @return
   */
  @Override
  @SneakyThrows
  public String writeValue() {
    RReadWriteLock lock = redissonClient.getReadWriteLock("rw-lock");
    lock.writeLock().lock();
    String uuid;
    try {
      uuid = UUID.fastUUID().toString();
      TimeUnit.SECONDS.sleep(30);
      redisUtil.set(uuid, "wv");
    } finally {
      lock.writeLock().unlock();
    }

    return uuid;
  }

  @Override
  public Map getAllBrands() {
    Map brands = redisUtil.get(BRANDS_KEY);
    if (ObjectUtil.isNull(brands)) {
      brands = getWithLock();
    }

    return brands;
  }

  /**
   *
   *
   * <pre>
   *     1. redisson 获取锁时时阻塞等待, 而不是自旋
   *         - lock.lock(long leaseTime, TimeUnit unit): 不会自动续期, 过期之后就会被删除
   *     2. redisson 获取分布式锁, 名字相同即为一把锁
   *     3. redisson 不会出现死锁: 锁的过期时间默认为 30s
   *     4. redisson 锁的自动续期: 看门狗
   *        - lock(-1, TimeUnit unit): 获取锁, 设置默认的时间哪位30s, 并在占锁成功之后设置一个定时器对锁进行续期[30s/3=10s]
   *
   *     5. 最佳实战:
   *        - lock(20, TimeUtil.SECONDS): 省下了续期操作, 手动解锁
   *
   * </pre>
   *
   * @return
   */
  private Map getWithLock() {

    // 1. 获取分布式锁, 名字相同即为一把锁
    RLock lock = redissonClient.getLock(REDIS_DISTRIBUTE_LOCK_KEY);
    lock.lock(); // 阻塞等待
    Map brands;
    try {
      brands = redisUtil.get(BRANDS_KEY);
      if (ObjectUtil.isNotNull(brands)) {
        return brands;
      }
      brands = getFromDB(true);
      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
    } finally {
      lock.unlock();
    }

    return brands;
  }

  /**
   * Query core logic.
   *
   * @return
   */
  @SneakyThrows
  private Map getFromDB(boolean isLongLogic) {
    log.info("query database.");
    if (isLongLogic) {
      TimeUnit.SECONDS.sleep(50);
    }
    Map brands = new HashMap(1);
    brands.put("zack", 18);
    return brands;
  }

  @SneakyThrows
  private Map getFromDB() {
    return getFromDB(false);
  }
}
