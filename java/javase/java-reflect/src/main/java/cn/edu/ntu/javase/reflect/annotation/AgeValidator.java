package cn.edu.ntu.javase.reflect.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * use setAge() to limit: min=18, max=100, else will throw exceptions <br>
 *
 * @author zack <br/>
 * @create 2020-02-10 16:58 <br/>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface AgeValidator {
    public int min();
    public int max();
}
