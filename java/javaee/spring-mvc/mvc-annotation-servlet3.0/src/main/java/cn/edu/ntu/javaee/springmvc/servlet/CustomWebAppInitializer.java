package cn.edu.ntu.javaee.springmvc.servlet;

import cn.edu.ntu.javaee.springmvc.servlet.configuration.RootConfig;
import cn.edu.ntu.javaee.springmvc.servlet.configuration.ServletConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * this is entrance class, spring-webmvc jar will find out this class and execute it.
 *
 * @author zack <br>
 * @create 2020-05-03 18:30 <br>
 */
@Slf4j
public class CustomWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * this class is same function with config application.xml in web.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    /**
     * this class is same function with config application4mvc.xml in web.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {ServletConfig.class};
    }

    /**
     * this class is same function with config mapping servlet in web.xml
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
