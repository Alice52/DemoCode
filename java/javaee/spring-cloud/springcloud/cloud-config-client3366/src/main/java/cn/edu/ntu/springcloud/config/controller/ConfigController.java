package cn.edu.ntu.springcloud.config.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack <br>
 * @create 2020-04-11 16:33 <br>
 */
@RestController
@RefreshScope
@RequestMapping(value = "/config")
public class ConfigController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigController.class);

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/get/dev")
    public JsonResult getConfigInfo() {

        return new JsonResult(200, "success", configInfo);
    }
}
