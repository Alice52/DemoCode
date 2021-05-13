package cn.edu.ntu.springboot.mvc.controller;

import cn.edu.ntu.springboot.mvc.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Email;

/** @author zack */
@PropertySource(value = {"classpath:person.properties"})
@RestController
@Slf4j
public class HelloController {

    @Resource public Person person;

    /** do not work with @Value */
    @Email
    @Value("${name:mars}")
    private String name;

    @Value("${age:18}")
    private int age;

    @Value("${idCard:654321}")
    private long IdCard;

    @GetMapping(value = "/person")
    public Person hello() {
        log.info("Autowired person: {}", person);
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setIdCard(IdCard);
        person.setCountry("China");
        return person;
    }
}
