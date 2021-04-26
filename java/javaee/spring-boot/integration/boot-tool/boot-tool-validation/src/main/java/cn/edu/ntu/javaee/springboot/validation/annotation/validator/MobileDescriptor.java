package cn.edu.ntu.javaee.springboot.validation.annotation.validator;

import cn.edu.ntu.javaee.springboot.validation.annotation.Mobile;
import com.github.xiaoymin.knife4j.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zack <br>
 * @create 2020-08-01 23:05 <br>
 * @project validation <br>
 */
public class MobileDescriptor implements ConstraintValidator<Mobile, String> {

  private static final Pattern MOBILE_PATTERN = Pattern.compile("^[1]\\d{10}$");
  private boolean required = false;

  @Override
  public void initialize(Mobile constraintAnnotation) {
    required = constraintAnnotation.required();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (!required && StrUtil.isBlank(value)) {
      return true;
    }

    if (StrUtil.isBlank(value)) {
      return false;
    }
    Matcher m = MOBILE_PATTERN.matcher(value);
    return m.matches();
  }
}
