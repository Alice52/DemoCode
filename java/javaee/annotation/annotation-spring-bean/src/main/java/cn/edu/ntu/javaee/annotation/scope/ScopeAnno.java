package cn.edu.ntu.javaee.annotation.scope;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zack <br>
 * @create 2020-04-29 18:51 <br>
 */
@Configuration
public class ScopeAnno {

    /**
     * The instance of person is singleton default, can change by @Scope<br>
     *
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE: will create object and put it to IOC container
     *     when get this bean from IOC for each time rather than IOC created.
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON: will create object and put it to IOC container
     *     when IOC created.
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * @return Person
     */
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(value = "person")
    public Person injectPerson() {
        return new Person(19, "alice52");
    }
}
