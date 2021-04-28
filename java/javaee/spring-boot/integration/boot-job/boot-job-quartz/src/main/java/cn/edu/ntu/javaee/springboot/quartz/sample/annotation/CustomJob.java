package cn.edu.ntu.javaee.springboot.quartz.sample.annotation;

import java.lang.annotation.*;

/**
 * @author zack <br>
 * @create 2021-04-28<br>
 * @project integration <br>
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Deprecated
public @interface CustomJob {}
