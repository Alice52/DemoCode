package top.hubby.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import top.hubby.event.event.OrderCreateEvent;
import top.hubby.event.service.Impl.OrderServiceImpl;

/**
 * @author asd <br>
 * @create 2021-09-27 2:44 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@Component
public class WechatListener implements SmartApplicationListener {

    @Override
    public int getOrder() {
        return 1;
    }

    /** 监听器智能所在之一，能够根据事件类型动态监听 */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }

    /** 监听器智能所在之二，能够根据事件发布者类型动态监听 */
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceImpl.class;
    }

    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        // 发送微信
        log.info(
                event.getContentList().get(0)
                        + ",您的订单:"
                        + event.getContentList().get(1)
                        + "创建成功! ----by wechat");
    }
}
