package cn.edu.ntu.springcloud.payment6.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zack <br>
 * @create 2020-03-30 23:06 <br>
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping(value = "/consul")
    public JsonResult get() {
        return new JsonResult(200, UUID.randomUUID().toString(), null);
    }
}
