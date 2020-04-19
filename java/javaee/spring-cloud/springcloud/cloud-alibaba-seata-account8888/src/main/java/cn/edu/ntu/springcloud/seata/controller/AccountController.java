package cn.edu.ntu.springcloud.seata.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.seata.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public JsonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new JsonResult(200,"扣减账户余额成功！");
    }
}
