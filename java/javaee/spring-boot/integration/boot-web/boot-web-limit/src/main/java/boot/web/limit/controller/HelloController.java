package boot.web.limit.controller;

import boot.web.limit.annotation.IdempotentRequest;
import boot.web.limit.annotation.LimitRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-04-12 14:27 <br>
 * @project integration <br>
 */
@RestController
public class HelloController {

    @GetMapping("/api")
    public String api() {
        return "PONG";
    }

    @LimitRequest(count = 5, time = 10)
    @GetMapping("/limit-api")
    public String limit() {
        return "PONG";
    }

    @IdempotentRequest(time = 2, timeUnit = TimeUnit.SECONDS)
    @GetMapping("/idempotent")
    public String idempotent() {
        return "PONG";
    }
}
