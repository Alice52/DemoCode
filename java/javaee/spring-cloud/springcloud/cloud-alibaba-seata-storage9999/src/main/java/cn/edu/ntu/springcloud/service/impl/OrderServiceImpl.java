package cn.edu.ntu.springcloud.service.impl;

import cn.edu.ntu.springcloud.dao.OrderDao;
import cn.edu.ntu.springcloud.domain.Order;
import cn.edu.ntu.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-26 15:20
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource private OrderDao orderDao;

    /** 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态 简单说：下订单->扣库存->减余额->改状态 */
    @Override
    @GlobalTransactional(name = "cloud_seata_tx_group")
    public void create(Order order) {
        log.info("----->开始新建订单");
        // 1 新建订单
        orderDao.create(order);

        // 4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }
}
