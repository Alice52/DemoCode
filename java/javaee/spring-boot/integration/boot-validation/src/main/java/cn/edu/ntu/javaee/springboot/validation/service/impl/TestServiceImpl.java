package cn.edu.ntu.javaee.springboot.validation.service.impl;

import cn.edu.ntu.javaee.springboot.validation.component.SpringUtil;
import cn.edu.ntu.javaee.springboot.validation.service.ITestService;
import cn.edu.ntu.javaee.springboot.validation.vo.UserVO;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2020-07-28 20:57 <br>
 * @project jsr303 <br>
 */
@Service
public class TestServiceImpl implements ITestService, SmartInitializingSingleton {

  /**
   * thread unsafe:
   *
   * <p>but can use <code>@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)</code> to make it safe
   * thread.
   */
  private ITestService testService = null;

  // SpringUtil.getBean(ITestService.class);

  @Override
  public String validate(String email) {
    return email;
  }

  @Override
  public UserVO register(UserVO userVO) {

    userVO.setEmail("aaaa");
    validate(userVO.getEmail());
    return userVO;
  }

  /**
   * this validation is work by using proxy object method calling,
   *
   * <p>due to @Validated in interface will make it[interface] to aop proxy object,
   *
   * <p>then spring will be able to validate method parameter annotation by Pointcut.
   *
   * @param email
   * @return string
   */
  @Override
  public String validateBetweenService(String email) throws Exception {

    // TODO: this validation is not work
    validateInService(null);

    // TODO: https://github.com/Alice52/java-ocean/issues/134
    // ITestService proxy = (ITestService) AopContext.currentProxy();

    String validate = testService.validate("hhhh");
    return validate;
  }

  private String validateInService(@NotNull String email) {

    // TODO: this validation is not work
    return validate(null);
  }

  @Override
  public Object hello(Integer id, String name) {
    return id;
  }

  @Override
  public void afterSingletonsInstantiated() {
    testService = SpringUtil.getBean(ITestService.class);
  }
}
