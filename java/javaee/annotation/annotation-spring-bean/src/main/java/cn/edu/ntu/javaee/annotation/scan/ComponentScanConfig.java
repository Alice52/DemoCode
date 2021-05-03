package cn.edu.ntu.javaee.annotation.scan;

import cn.edu.ntu.javaee.annotation.scan.filer.CustomTypeFilter;
import cn.edu.ntu.javaee.annotation.service.PersonService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author zack <br>
 * @create 2020-04-29 17:59 <br>
 */
@Configuration
@ComponentScan(
        basePackages = {"cn.edu.ntu.javaee.annotation"},
        includeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    classes = {Controller.class}),
            @ComponentScan.Filter(
                    type = FilterType.ASSIGNABLE_TYPE,
                    classes = {PersonService.class}),
            @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Service"),
            @ComponentScan.Filter(
                    type = FilterType.CUSTOM,
                    classes = {CustomTypeFilter.class})
        },
        useDefaultFilters = false)
public class ComponentScanConfig {}
