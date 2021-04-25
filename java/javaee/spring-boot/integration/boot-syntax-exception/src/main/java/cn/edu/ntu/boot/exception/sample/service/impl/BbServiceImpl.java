package cn.edu.ntu.boot.exception.sample.service.impl;

import cn.edu.ntu.boot.exception.sample.service.AaService;
import cn.edu.ntu.boot.exception.sample.service.BbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2021-04-25 15:23 <br>
 * @project integration <br>
 */
@Slf4j
@Service
public class BbServiceImpl implements BbService {

  @Resource private AaService aService;

  @Override
  public void helloB(@NotNull(message = "名称不能为空") String name) {
    aService.hello4B(name);
  }

  @Override
  public void hello4A(@NotNull(message = "名称不能为空") String name) {
    log.info("a service call hello4A method.");
  }
}
