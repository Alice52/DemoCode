package top.hubby.boot.tool.guava.event.controller;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author asd <br>
 * @create 2021-09-27 1:56 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@RestController
@RequestMapping("/event")
public class EventTestsController {
    @Resource private EventBus eventBus;

    @PostMapping("/{bizId}")
    public void testPublishEvent(@PathVariable("bizId") Long bizId) {
        log.info("Thread-Id");
        eventBus.post(bizId);
    }

    @PostMapping("/dead-event/{bizId}")
    public void testPublishDeadEvent(@PathVariable("bizId") Integer bizId) {
        eventBus.post(bizId);
    }

    @PostMapping("/string-event/{bizId}")
    public void testPublishStringEvent(@PathVariable("bizId") String bizId) {
        eventBus.post(bizId);
    }
}
