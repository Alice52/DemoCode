package boot.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author zack <br>
 * @create 2021-05-13 12:23 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String list() {
        log.info("测试列表查询");
        return "测试列表查询";
    }

    @PostMapping
    public String add() {
        log.info("测试列表添加");
        return "测试列表添加";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id) {
        log.info("测试列表修改");
        return "测试列表修改";
    }
}
