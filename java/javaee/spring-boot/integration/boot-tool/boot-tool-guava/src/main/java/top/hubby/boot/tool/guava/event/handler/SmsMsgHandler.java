package top.hubby.boot.tool.guava.event.handler;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-09-27 2:00 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class SmsMsgHandler {

    @Subscribe
    public void handle(Long businessId) {
        log.info("send sms msg: {}", businessId);
    }

    @Subscribe
    public void handle(String businessId) {
        log.info("send sms msg for string: {}", businessId);
    }
}
