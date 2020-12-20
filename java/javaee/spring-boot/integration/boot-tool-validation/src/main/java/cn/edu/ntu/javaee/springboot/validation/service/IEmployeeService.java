package cn.edu.ntu.javaee.springboot.validation.service;

import cn.edu.ntu.javaee.springboot.validation.vo.Employee;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2020-08-01 19:55 <br>
 * @project validation <br>
 */
@Validated
public interface IEmployeeService {

  /**
   * This validation will not be worked.
   *
   * @param employee
   */
  void addEmploy(Employee employee);

  /**
   * This validation will be worked.
   *
   * @param employee
   */
  void addEmploy2(@Valid Employee employee);

  /**
   * This validation will be worked.
   *
   * @param email
   * @return
   */
  Employee getByEmail(@NotNull String email);

  /**
   * Please not use validation to validate result.
   *
   * <p>Please use Assertion to check result.
   *
   * @param id
   * @return
   */
  @NotNull
  Employee getById(@NotNull Integer id);

  /**
   * This validation will be used by validateInService.
   *
   * @param email
   */
  void validate(@NotNull String email);

  /**
   * This is to validate between service.
   *
   * <p>if want the internal method[validate] worked, please get proxy of service,
   *
   * <p>>then to call validate() method.
   *
   * @param email
   */
  void validateInService(@Email String email);
}
