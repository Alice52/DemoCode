package cn.edu.ntu.javaee.annotation.bean;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zack <br>
 * @create 2020-04-30 11:45 <br>
 */
@Configuration
public class BeanInitAndDestroy {

    /**
     * singleton: <br>
     * - init: create an object when the container is created, and call the Init () method <br>
     *    -destroy: called when the container is closed <br>
     * prototype: <br>
     *    -init: the object will be created when it is used for the first time, and the Init ()
     * method is called <br>
     * -destroy: The container will only create this Bean but will not destroy [Manage] <br>
     *
     * @return Person
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = "person", initMethod = "init", destroyMethod = "destroy")
    public Person injectPerson() {

        return new Person();
    }
}
