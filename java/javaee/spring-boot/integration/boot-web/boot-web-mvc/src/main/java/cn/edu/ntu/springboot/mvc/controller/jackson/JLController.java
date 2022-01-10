package cn.edu.ntu.springboot.mvc.controller.jackson;

import cn.edu.ntu.springboot.mvc.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Jackson and lombok deserialize bug.
 *
 * @author asd <br>
 * @create 2022-01-10 10:42 AM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@RestController
@RequestMapping("/lombok-jackson")
public class JLController {

    @PostMapping("/deserilize")
    public UserDTO testDeserilize(@RequestBody UserDTO user) {
        return user;
    }
}
