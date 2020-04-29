package cn.edu.ntu.springboot.mvc.controller;

import cn.edu.ntu.javaee.boot.common.enumeration.HttpErrorCode;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import cn.edu.ntu.springboot.mvc.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Email;

@PropertySource(value = {"classpath:person.properties"})
@RestController
public class HelloController {
  private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

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
  public JsonObject hello() {
    LOG.info("Autowired person: {}", person);
    Person person = new Person();
    person.setName(name);
    person.setAge(age);
    person.setIdCard(IdCard);
    person.setCountry("China");
    return new JsonObject(HttpErrorCode.OK, "get person[" + name + "] info success", person);
  }
}
