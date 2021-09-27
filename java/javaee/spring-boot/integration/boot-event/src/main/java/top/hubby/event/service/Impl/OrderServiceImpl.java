package top.hubby.event.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import top.hubby.event.event.OrderCreateEvent;
import top.hubby.event.service.IOrderService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author asd <br>
 * @create 2021-09-27 2:45 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource private ApplicationContext applicationContext;
    @Resource private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void saveOrder() {
        // 1.创建订单
        log.info("订单创建成功");
        // 2.发布事件
        ArrayList<String> contentList = new ArrayList<>();
        contentList.add("heling");
        contentList.add("123456789");
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(this, "订单创建", contentList);
        // ApplicationContext是我们的事件容器上层，我们发布事件，也可以通过此容器完成发布
        applicationContext.publishEvent(orderCreateEvent);

        // applicationEventPublisher.publishEvent(orderCreateEvent);//也可以
        log.info("finished!");
    }
}
