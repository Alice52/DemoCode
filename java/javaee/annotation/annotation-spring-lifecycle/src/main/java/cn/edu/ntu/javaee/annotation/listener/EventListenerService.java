package cn.edu.ntu.javaee.annotation.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author zack <br>
 * @create 2020-05-08 20:57 <br>
 * @project annotation <br>
 */
@Service
@Slf4j
public class EventListenerService {

    @EventListener(classes = {ApplicationEvent.class})
    public void listener(ApplicationEvent applicationEvent) {
        log.info("event: {}", applicationEvent);
    }
}
