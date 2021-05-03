package aop.bean.validation.verification.annotations;

import aop.bean.validation.verification.ValidationPolicy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Validated {

    ValidationPolicy policy() default ValidationPolicy.ADD;
}
