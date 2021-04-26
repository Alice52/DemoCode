package cn.edu.ntu.javaee.springboot.validation.controller;

import cn.edu.ntu.javaee.springboot.validation.service.impl.AopService;
import cn.edu.ntu.javaee.springboot.validation.vo.Department;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-08-01 18:39 <br>
 * @project validation <br>
 */
@Api
@RestController
@RequestMapping("/aop")
public class AopController {

  @Resource private AopService aopService;

  @PostMapping
  public void add(@RequestBody Department department) {

    aopService.addDepartment(department);
  }

  @GetMapping
  public void query() {

    aopService.validate(null);
  }
}
