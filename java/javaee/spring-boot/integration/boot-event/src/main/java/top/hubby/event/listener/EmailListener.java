package top.hubby.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import top.hubby.event.event.OrderCreateEvent;

/**
 * @author asd <br>
 * @create 2021-09-27 2:57 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@Component
public class EmailListener {

    @Async
    @EventListener(OrderCreateEvent.class)
    public void onOrdered(OrderCreateEvent event) {
        // 发送邮件
        log.info(
                event.getContentList().get(0)
                        + ",您的订单:"
                        + event.getContentList().get(1)
                        + "创建成功! ----by email");
    }
}
