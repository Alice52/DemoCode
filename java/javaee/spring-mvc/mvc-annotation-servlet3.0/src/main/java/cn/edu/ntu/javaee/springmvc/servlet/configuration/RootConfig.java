package cn.edu.ntu.javaee.springmvc.servlet.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * this class function is same as application.xml
 *
 * @author zack <br>
 * @create 2020-05-03 18:34 <br>
 */
@Configuration
@ComponentScan(
        value = "cn.edu.ntu.javaee.springmvc.servlet",
        excludeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    classes = {Controller.class})
        })
public class RootConfig {}
