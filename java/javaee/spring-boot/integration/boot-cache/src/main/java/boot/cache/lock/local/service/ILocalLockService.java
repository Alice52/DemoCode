package boot.cache.lock.local.service;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-01-05 21:06 <br>
 * @project springboot <br>
 */
public interface ILocalLockService {

  /**
   * Get all brands, mask api.
   *
   * @return
   */
  Map getAllBrands();
}
