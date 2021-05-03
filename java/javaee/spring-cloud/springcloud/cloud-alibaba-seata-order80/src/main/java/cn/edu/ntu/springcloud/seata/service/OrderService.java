package cn.edu.ntu.springcloud.seata.service;

import cn.edu.ntu.springcloud.seata.entity.Order;

/**
 * @auther zzyy
 * @create 2020-02-26 15:19
 */
public interface OrderService {
    void create(Order order);
}
