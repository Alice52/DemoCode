package aop.bean.validation.verification;

import aop.bean.validation.verification.annotations.CheckRegexp;

public class User {

  @CheckRegexp(
      expression = "[A-Za-z]{2,}",
      messageRef = "error_validate_firstName",
      policy = ValidationPolicy.ADD)
  private String firstName;

  @CheckRegexp(
      expression = "[A-Za-z]{2,}",
      messageRef = "error_validate_lastName",
      policy = ValidationPolicy.ADD)
  private String lastName;

  @CheckRegexp(
      expression =
          "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+" + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})",
      messageRef = "error_validate_email",
      policy = ValidationPolicy.ADD)
  private String email;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
