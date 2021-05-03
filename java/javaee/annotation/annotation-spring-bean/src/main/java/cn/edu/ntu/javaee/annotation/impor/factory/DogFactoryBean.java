package cn.edu.ntu.javaee.annotation.impor.factory;

import cn.edu.ntu.javaee.annotation.common.model.Dog;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zack <br>
 * @create 2020-04-29 22:18 <br>
 */
public class DogFactoryBean implements FactoryBean<Dog> {

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }
}
