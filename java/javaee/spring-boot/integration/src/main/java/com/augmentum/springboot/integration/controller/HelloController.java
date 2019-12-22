package com.augmentum.springboot.integration.controller;

import cn.edu.ntu.common.enumeration.HttpErrorCode;
import cn.edu.ntu.common.model.JsonObject;
import cn.edu.ntu.common.model.Person;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack
 * @create 2019-12-22 18:39
 * @function
 */
@Api(value = "HelloController")
@RestController
public class HelloController {
  private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

  @GetMapping(value = "/person")
  public JsonObject hello() {
    Person person = new Person();
    person.setAge(18);
    person.setCountry("China");
    return new JsonObject(HttpErrorCode.OK, "get person info success", person);
  }
}
