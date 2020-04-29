package cn.edu.ntu.boot.swagger2.controller;

import cn.edu.ntu.javaee.boot.common.model.ErrorMessage;
import cn.edu.ntu.javaee.boot.common.model.Person;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * @author zack <br>
 * @create 2020-04-27 09:19 <br>
 */
@RestController
@Api(
    value = "swagger-controller",
    tags = {"swagger2"},
    hidden = false)
@ApiResponses({@ApiResponse(code = 400, message = "Internal Error", response = ErrorMessage.class)})
public class SwaggerController {

  @GetMapping(value = "/person/{id}")
  @ApiOperation(value = "Get Person Api")
  @ApiImplicitParam(name = "age", value = "age", required = true, dataType = "Long")
  public Person get(@Valid Person person, @PathVariable(value = "id", required = true) Long id) {
    return person;
  }

  @GetMapping(value = "/ignore")
  @ApiIgnore
  public Person ignore(Person person) {
    return person;
  }
}
