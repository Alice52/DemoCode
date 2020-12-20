package cn.edu.ntu.springboot.mvc.service.impl;

import cn.edu.ntu.springboot.mvc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-09-08 20:38 <br>
 * @project spring <br>
 */
@Component
public class OneUserServiceImpl implements IUserService {

  private static final Logger LOG = LoggerFactory.getLogger(OneUserServiceImpl.class);

  @Override
  public void helloWorld() {
    LOG.info("OneUserServiceImpl");
  }
}
