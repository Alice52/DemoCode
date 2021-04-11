package cn.edu.ntu.javaee.springboot.syntax.controller;

import cn.edu.ntu.javaee.boot.common.enumeration.HttpErrorCode;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import cn.edu.ntu.javaee.springboot.syntax.exception.UserNotExistException;
import cn.edu.ntu.javaee.springboot.syntax.model.Person;
import cn.edu.ntu.javaee.springboot.syntax.service.HelloService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Email;

@Api(value = "HelloController")
@PropertySource(value = {"classpath:person.properties"})
@RestController
public class HelloController {
  private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
  @Resource public Person person;
  @Resource HelloService service;
  @Email // do not work with @Value
  @Value("${name:mars}")
  private String name;

  @Value("${age:18}")
  private int age;

  @Value("${idCard:654321}")
  private long IdCard;

  @GetMapping(value = "/person")
  public JsonObject hello() {
    LOG.info("Autowired person: {}", person);
    Person person = new Person();
    person.setName(name);
    person.setAge(age);
    person.setIdCard(IdCard);
    person.setCountry("China");
    LOG.info("Inspect HelloService{} success", service);
    return new JsonObject(HttpErrorCode.OK, "get person[" + name + "] info success", person);
  }

  @GetMapping(value = "/exception")
  public JsonObject exception() {
    throw new UserNotExistException();
  }
}
