package cn.edu.ntu.boot.exception.sample.service;

/**
 * If this class is marked as @Validated, then the inject on CcServiceImpl will lead
 * BeanCurrentlyInCreation.
 *
 * @author zack <br>
 * @create 2021-04-25 15:55 <br>
 * @project integration <br>
 */
public interface CcService {

  /**
   * 整个大的操作: 校验 + 具体的数据库影响
   *
   * @param name
   */
  void transactionWithValidate(String name);

  /**
   * 真的的事务踢
   *
   * @param name
   */
  void transactionReal(String name);
}
