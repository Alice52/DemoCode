package top.hubby.boot.tool.guava.event.configuration;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.hubby.boot.tool.guava.event.handler.DefaultEventHandler;
import top.hubby.boot.tool.guava.event.handler.EmailMsgHandler;
import top.hubby.boot.tool.guava.event.handler.SmsMsgHandler;
import top.hubby.boot.tool.guava.event.handler.SubExceptionHandler;

import javax.annotation.PostConstruct;

/**
 * @author asd <br>
 * @create 2021-09-27 1:52 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@Configuration
public class EventConfig {

    @Bean
    public EventBus eventBus() {

        return new EventBus(new SubExceptionHandler());
        // AsyncEventBus will start new thread to work for each handler.
        // return new AsyncEventBus(Executors.newFixedThreadPool(10), new SubExceptionHandler());
    }

    @PostConstruct
    public void register() {
        eventBus().register(new EmailMsgHandler());
        eventBus().register(new SmsMsgHandler());
        eventBus().register(new DefaultEventHandler());
    }
}
