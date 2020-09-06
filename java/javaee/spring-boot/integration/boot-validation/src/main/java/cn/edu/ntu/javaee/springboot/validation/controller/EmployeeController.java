package cn.edu.ntu.javaee.springboot.validation.controller;

import cn.edu.ntu.javaee.springboot.validation.annotation.ValidList;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Add;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Update;
import cn.edu.ntu.javaee.springboot.validation.service.IEmployeeService;
import cn.edu.ntu.javaee.springboot.validation.vo.Employee;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.groups.Default;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-08-01 19:24 <br>
 * @project validation <br>
 */
@Api
@RestController
@Validated
@RequestMapping("employee")
public class EmployeeController {

  @Resource private IEmployeeService employeeService;

  /**
   * @Valid cannot use group to validate.
   *
   * <p>and @Valid will donot validate id, which is not belong to Default.
   *
   * @param employee
   * @return
   */
  @PostMapping
  public Object add(@RequestBody @Valid Employee employee) {
    employeeService.addEmploy(employee);

    return "ok";
  }

  /**
   * no matter @Validated or @Valid will cannot validate list per value.
   *
   * <p>due to it validate list with no constraint.
   *
   * @param employeeList
   * @return
   */
  @PostMapping("/list-failed")
  public Object addList(@RequestBody @Valid List<Employee> employeeList) {

    return "ok";
  }

  @PostMapping("/list")
  public Object addListValidation(
      @RequestBody
          @ValidList(
              quickFail = true,
              values = {Add.class, Default.class})
          List<Employee> employeeList) {

    return "ok";
  }

  @PostMapping("/list-directly")
  public Object addValidationList(@RequestBody List<@Valid Employee> employeeList) {

    return "ok";
  }

  /**
   * @param employee
   * @return
   */
  @PutMapping
  public Object update(@RequestBody @Validated({Update.class, Default.class}) Employee employee) {
    employeeService.addEmploy(employee);

    return "ok";
  }

  /**
   * This validation @Email is worked.
   *
   * @param email
   * @return
   */
  @GetMapping("/{email}")
  public Object get(@Email @PathVariable("email") String email) {
    employeeService.getByEmail(null);
    return "ok";
  }

  /**
   * This validation @Email is worked.
   *
   * @param id
   * @return Object
   */
  @PostMapping("/{id}")
  public Object get(@PathVariable("id") Integer id) {
    Employee employee = employeeService.getById(id);
    return employee;
  }

  @GetMapping("/validateInService/{email}")
  public Object validateInService(@PathVariable("email") String email) {
    employeeService.validateInService(email);
    return "ok";
  }
}
