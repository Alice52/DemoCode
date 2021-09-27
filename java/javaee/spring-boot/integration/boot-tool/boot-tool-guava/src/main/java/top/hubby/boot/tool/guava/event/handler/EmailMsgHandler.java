package top.hubby.boot.tool.guava.event.handler;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-09-27 1:52 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class EmailMsgHandler {
    @Subscribe
    public void handle(Long businessId) {
        throw new RuntimeException("send email msg failed");
        // log.info("send email msg: {}", businessId);
    }

    @Subscribe
    public void handle(String businessId) {
        log.info("send email msg 4 string: {}", businessId);
    }
}
