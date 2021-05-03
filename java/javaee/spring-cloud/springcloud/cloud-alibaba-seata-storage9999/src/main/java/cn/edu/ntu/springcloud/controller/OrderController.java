package cn.edu.ntu.springcloud.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.domain.Order;
import cn.edu.ntu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController {
    @Resource private OrderService orderService;

    @GetMapping("/order/create")
    public JsonResult create(Order order) {
        orderService.create(order);
        return new JsonResult(200, "订单创建成功");
    }
}
