package top.hubby.event.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hubby.event.service.IOrderService;

import javax.annotation.Resource;

/**
 * @author asd <br>
 * @create 2021-09-27 2:52 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource private IOrderService orderService;

    @PostMapping
    public void order() {
        orderService.saveOrder();
    }
}
