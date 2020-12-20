package cn.edu.ntu.springboot.mvc.controller;

import cn.edu.ntu.springboot.mvc.service.IUserService;
import cn.edu.ntu.springboot.mvc.service.impl.OneUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-09-08 20:42 <br>
 * @project spring <br>
 */
@RestController
public class MoreImplAutowireTestController {
  private static final Logger LOG = LoggerFactory.getLogger(MoreImplAutowireTestController.class);

  /* ok */
  @Resource List<IUserService> userServices;

  /* error due to  expected single matching bean but found 2*/
  //  @Resource IUserService userService;

  @Qualifier("oneUserServiceImpl")
  @Resource
  IUserService uService;

  @Resource IUserService oneUserServiceImpl;

  @Resource OneUserServiceImpl userService;

  @GetMapping("/test-more-impl")
  public void moreImplTest() {
    oneUserServiceImpl.helloWorld();
    uService.helloWorld();
    userService.helloWorld();
    LOG.info("aaa");

    userServices.forEach(x -> x.helloWorld());
  }
}
