package top.hubby.boot.tool.guava.event.handler;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-09-27 2:06 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class DefaultEventHandler {
    @Subscribe
    public void handle(DeadEvent event) {
        log.info("no subscriber {}", event);
    }
}
