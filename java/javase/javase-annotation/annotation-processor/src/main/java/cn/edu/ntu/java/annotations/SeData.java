package cn.edu.ntu.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zack <br/>
 * @create 2022-12-14 00:11 <br/>
 * @project annotation <br/>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface SeData {}
