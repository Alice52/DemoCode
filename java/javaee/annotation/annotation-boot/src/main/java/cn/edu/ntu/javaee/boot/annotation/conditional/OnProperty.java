package cn.edu.ntu.javaee.boot.annotation.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * swagger2 in config is true, then will execute follow code. <br>
 *
 * @author zack <br>
 * @create 2020-04-29 19:44 <br>
 */
@Configuration
@ConditionalOnProperty(
        prefix = "swagger2",
        value = {"enable"},
        havingValue = "true")
public class OnProperty {}
