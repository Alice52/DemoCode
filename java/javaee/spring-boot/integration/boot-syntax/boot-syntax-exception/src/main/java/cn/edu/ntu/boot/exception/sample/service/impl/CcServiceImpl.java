package cn.edu.ntu.boot.exception.sample.service.impl;

import cn.edu.ntu.boot.exception.sample.service.CcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2021-04-25 15:55 <br>
 * @project integration <br>
 */
@Service
@Slf4j
public class CcServiceImpl implements CcService {
  @Resource private CcService ccService;

  @Override
  public void transactionWithValidate(@NotNull(message = "名称不能为空") String name) {
    log.info("validate transaction ...");
    ccService.transactionReal(name);
  }

  @Override
  public void transactionReal(String name) {
    log.info("real commit transaction ...");
  }
}
