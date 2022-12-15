package cn.edu.ntu.java.annotations;

import java.lang.annotation.*;

/**
 * @author alice52
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
@Inherited
public @interface Serial {
    long value() default 4654816360795179002L;
}
