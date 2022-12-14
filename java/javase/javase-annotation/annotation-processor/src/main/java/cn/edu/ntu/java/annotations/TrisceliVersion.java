package cn.edu.ntu.java.annotations;

import java.lang.annotation.*;

/**
 * @author alice52
 */
@Documented
@Retention(RetentionPolicy.SOURCE) // 只在编译期有效, 最终不会打进 class 文件中
@Target({ElementType.FIELD}) // 仅允许作用于类属性之上
public @interface TrisceliVersion {}
