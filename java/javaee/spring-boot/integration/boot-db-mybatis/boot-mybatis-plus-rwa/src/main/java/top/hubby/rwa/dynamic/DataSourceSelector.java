package top.hubby.rwa.dynamic;

import top.hubby.rwa.constants.enums.DynamicDataSourceEnum;

import java.lang.annotation.*;

/**
 * @author asd <br>
 * @create 2021-09-28 4:45 PM <br>
 * @project boot-security-shiro <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSelector {

    DynamicDataSourceEnum value() default DynamicDataSourceEnum.MASTER;

    boolean clear() default true;
}
