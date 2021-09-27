package top.hubby.boot.tool.guava.event.handler;

import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-09-27 2:25 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class SubExceptionHandler implements SubscriberExceptionHandler {

    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
        log.info("handle sub encount exception: {} in context: {}", exception, context);
    }
}
