package boot.cache.lock.distibute.service;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-01-05 21:06 <br>
 * @project springboot <br>
 */
public interface IDistributeLockService {

  /**
   * Get all brands, mask api.
   *
   * @return
   */
  Map getAllBrands();

  /**
   * Read Lock.
   *
   * @return
   */
  String readValue();

  /**
   * Write Lock.
   *
   * @return
   */
  String writeValue();

  void lockSchoolDoor();

  void lockDoor();

  void go();
}
