package mq.direct.controller;

import mq.direct.DirectDeadSender;
import mq.direct.DirectSender;
import mq.direct.DirectTtlSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-03-06 21:11 <br>
 * @project mq <br>
 */
@RestController
@RequestMapping("/direct")
public class DirectController {

    @Resource DirectSender directSender;
    @Resource DirectTtlSender ttlSender;
    @Resource DirectDeadSender deadSender;

    @GetMapping("/send")
    public void send() {
        directSender.sendImmediately();
    }

    @GetMapping("/ttl-send")
    public void ttlSend() {
        ttlSender.sendImmediately();
    }

    @GetMapping("/dead-send")
    public void deadSend() {
        deadSender.sendImmediately();
    }
}
