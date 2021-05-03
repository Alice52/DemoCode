package cn.edu.ntu.boot.exception.sample.service.impl;

import cn.edu.ntu.boot.exception.sample.service.AaService;
import cn.edu.ntu.boot.exception.sample.service.BbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2021-04-25 15:23 <br>
 * @project integration <br>
 */
@Service
@Slf4j
public class AaServiceImpl implements AaService {

    @Resource private BbService bService;

    @Override
    @Validated
    public void helloA(@NotNull(message = "名称不能为空") String name) {
        bService.helloB(name);
    }

    @Override
    public void hello4B(@NotNull(message = "名称不能为空") String name) {
        log.info("b service call hello4B method.");
    }
}
