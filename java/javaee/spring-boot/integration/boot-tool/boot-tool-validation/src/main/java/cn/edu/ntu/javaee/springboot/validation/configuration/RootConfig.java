package cn.edu.ntu.javaee.springboot.validation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author zack <br>
 * @create 2020-07-27 23:56 <br>
 * @project jsr303 <br>
 */
@Configuration
public class RootConfig {

    /**
     * // TODO: confused.
     *
     * <p>I cannot understand what's function of this bean.
     *
     * @return methodValidationPostProcessor bean
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
