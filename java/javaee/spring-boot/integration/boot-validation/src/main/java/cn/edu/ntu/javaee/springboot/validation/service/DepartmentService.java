package cn.edu.ntu.javaee.springboot.validation.service;

import cn.edu.ntu.javaee.springboot.validation.vo.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * If we want validate in service between methods, so we should define interface rather than impl
 * class.
 *
 * @author zack <br>
 * @create 2020-08-01 19:55 <br>
 * @project validation <br>
 */
@Validated
@Service
public class DepartmentService {

  private static final Logger LOG = LoggerFactory.getLogger(DepartmentService.class);

  public void addDepartment(@Valid Department department) {
    LOG.info("add department success");
  }
}
