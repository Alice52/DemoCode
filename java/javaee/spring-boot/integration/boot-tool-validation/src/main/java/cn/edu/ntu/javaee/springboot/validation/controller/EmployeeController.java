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
@RequestMapping("employee")
public class EmployeeController {

  @Resource private IEmployeeService employeeService;

  /**
   * {@link Valid} cannot use group to validate.
   *
   * <p>and {@link Valid} will donot validate id, which is not belong to Default in this case. *
   *
   * <pre>
   *     Validated in this case without {@link Validated}
   * </pre>
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
   * Only {@link org.springframework.validation.annotation.Validated} integrate with ${@link
   * javax.validation.Valid } can validate list per value.<br>
   * And cannot use group feature in this case.
   *
   * <pre>
   *     Validated in this case must with {@link Validated}, else it will validate List with no constraint.
   * </pre>
   *
   * @param employeeList
   * @return
   */
  @PostMapping("/list-failed1")
  public Object addList(@RequestBody @Valid List<Employee> employeeList) {

    return "ok";
  }

  @PostMapping("/list-directly")
  public Object addValidationList(@RequestBody List<@Valid Employee> employeeList) {

    return "ok";
  }

  /**
   * Only {@link org.springframework.validation.annotation.Validated} integrate with ${@link
   * javax.validation.Valid } can validate list per value.<br>
   * And use {@link org.springframework.validation.annotation.Validated} to specify group info.
   *
   * <pre>
   *     Validated in this case must with {@link Validated}, else it will validate List with no constraint.
   * </pre>
   *
   * @param employeeList
   * @return
   */
  @PostMapping("/list-failed2")
  @Validated({Update.class, Default.class})
  public Object addListAndValidationInServiceImpl(@RequestBody @Valid List<Employee> employeeList) {

    return "ok";
  }

  /**
   * Use customized {@link ValidList } to validate and can use group.
   *
   * <pre>
   *     Validated in this case must with {@link Validated}, else it will validate List with no constraint.
   * </pre>
   *
   * @param employeeList
   * @return
   */
  @PostMapping("/list")
  public Object addListValidation(
      @RequestBody
          @ValidList(
              quickFail = true,
              values = {Add.class, Default.class})
          List<Employee> employeeList) {

    return "ok";
  }

  /**
   *
   *
   * <pre>
   *     Validated in this case without {@link Validated}
   * </pre>
   *
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
   * <pre>
   *     Validated in this case without {@link Validated}
   * </pre>
   *
   * @param email
   * @return
   */
  @GetMapping("/{email}")
  public Object get(@Email @PathVariable("email") String email) {
    employeeService.getByEmail(null);
    return "ok";
  }
  @GetMapping("/validateInService/{email}")
  public Object validateInService(@PathVariable("email") String email) {
    employeeService.validateInService(email);
    return "ok";
  }

  /**
   * This validation in service is worked with service {@link Validated}
   *
   * @param id
   * @return Object
   */
  @PostMapping("/{id}")
  public Object get(@PathVariable("id") Integer id) {
    Employee employee = employeeService.getById(id);
    return employee;
  }
}
