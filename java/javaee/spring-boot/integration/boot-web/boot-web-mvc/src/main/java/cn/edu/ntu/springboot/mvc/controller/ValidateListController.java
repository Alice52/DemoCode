package cn.edu.ntu.springboot.mvc.controller;

import cn.edu.ntu.springboot.mvc.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author asd <br>
 * @create 2022-03-09 4:57 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
@RestController
@RequestMapping("/validate")
@Validated
public class ValidateListController {
    @GetMapping(value = "/list")
    public Person hello(@RequestParam("emails") @NotNull List<@Email String> emails) {

        return null;
    }

    @GetMapping(value = "/ele")
    public Person hello(@RequestParam("emails") @Email String email) {

        return null;
    }
}
