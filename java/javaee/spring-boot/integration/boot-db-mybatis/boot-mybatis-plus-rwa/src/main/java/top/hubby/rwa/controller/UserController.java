package top.hubby.rwa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hubby.rwa.model.RwaUser;
import top.hubby.rwa.service.UserService;

import java.util.List;

/**
 * @author asd <br>
 * @create 2021-09-28 4:50 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping("/list")
    public List<RwaUser> userList() {
        return userService.listUser();
    }

    @RequestMapping("/update")
    public int update() {
        return userService.updateEntity();
    }

    @RequestMapping("/find")
    public RwaUser find() {
        return userService.find();
    }
}
