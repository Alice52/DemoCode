package cn.edu.ntu.java.annotation;

import cn.edu.ntu.java.processor.DataProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see DataProcessor
 * @author alice52
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface SeData {
}
