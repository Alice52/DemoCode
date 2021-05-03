package cn.edu.ntu.quartz.spring.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This util can obtain ioc bean.
 *
 * @author zack <br>
 * @create 2020-12-23 20:13 <br>
 * @project quartz <br>
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }
}
