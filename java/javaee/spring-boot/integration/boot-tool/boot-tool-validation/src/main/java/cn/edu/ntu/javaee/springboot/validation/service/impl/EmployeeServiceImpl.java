package cn.edu.ntu.javaee.springboot.validation.service.impl;

import cn.edu.ntu.javaee.springboot.validation.component.SpringUtil;
import cn.edu.ntu.javaee.springboot.validation.service.IEmployeeService;
import cn.edu.ntu.javaee.springboot.validation.vo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

/**
 * @author zack <br>
 * @create 2020-08-01 19:55 <br>
 * @project validation <br>
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService, SmartInitializingSingleton {

  private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
  private IEmployeeService employeeServiceProxy = null;

  @Override
  public void addEmploy(Employee employee) {
    LOG.info("add employee success");
  }

  @Override
  public void addEmploy2(Employee employee) {
    LOG.info("add employee success");
  }

  @Override
  public Employee getByEmail(String email) {
    LOG.info("query employee success");

    return null;
  }

  @Override
  public Employee getById(Integer id) {
    return null;
  }

  @Override
  public void validate(String email) {
    LOG.info("This is second service.");
  }

  @Override
  public void validateInService(String email) {
    LOG.info("This is first service.");

    // this is not worked because this is not proxy object.
    this.validate(null);
    employeeServiceProxy.validate(null);
  }

  @Override
  public void afterSingletonsInstantiated() {
    employeeServiceProxy = SpringUtil.getBean(IEmployeeService.class);
  }
}
