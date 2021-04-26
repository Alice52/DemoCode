package aop.bean.validation.verification.interfaces;

import aop.bean.validation.verification.CustomException;
import aop.bean.validation.verification.User;
import aop.bean.validation.verification.ValidationPolicy;
import aop.bean.validation.verification.annotations.CheckObject;
import aop.bean.validation.verification.annotations.Validated;

public interface UserDao {

  @Validated(policy = ValidationPolicy.ADD)
  void createUser(@CheckObject User user) throws CustomException;
}
