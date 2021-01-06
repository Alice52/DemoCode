package boot.cache.service;

import boot.cache.utils.RedisUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-01-05 21:06 <br>
 * @project springboot <br>
 */
@Slf4j
@Service
public class LockService implements ILockService {

  private static final String BRANDS_KEY = "BRANDS";

  @Resource RedisUtil redisUtil;

  /**
   * 大并发下, 会有多个请求的线程进入查数据库的方法.
   *
   * @return
   */
  @Override
  public Map getAllBrands() {
    Map brands = redisUtil.get(BRANDS_KEY);
    if (ObjectUtil.isNull(brands)) {
      brands = getBrandsFromDB();

      redisUtil.set(brands, BRANDS_KEY, 2, TimeUnit.HOURS);
    }

    return brands;
  }


  private Map getBrandsFromDB() {
    Map brands = redisUtil.get(BRANDS_KEY);
    if (ObjectUtil.isNull(brands)) {
      log.info("query database.");
      brands = new HashMap(1);
      brands.put("zack", 18);
    }

    return brands;
  }
}
