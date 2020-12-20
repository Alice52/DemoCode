package cn.edu.ntu.javaee.springboot.validation.annotation;

import cn.edu.ntu.javaee.springboot.validation.annotation.validator.MobileDescriptor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zack <br>
 * @create 2020-08-01 23:01 <br>
 * @project validation <br>
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {MobileDescriptor.class})
public @interface Mobile {

  boolean required() default false;

  String message() default "mobile number is invalid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
