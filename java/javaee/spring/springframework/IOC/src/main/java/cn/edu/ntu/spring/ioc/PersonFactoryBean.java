package cn.edu.ntu.spring.ioc;

import cn.edu.ntu.spring.entity.Address;
import cn.edu.ntu.spring.entity.Person;
import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

/**
 * @author zack
 * @create 2019-10-27 14:53
 * @function
 */
public class PersonFactoryBean implements FactoryBean<Person> {
  @Override
  public Person getObject() throws Exception {
    return new Person(10, new Date(), "zack", true, new Address(), "zzhang_xz@163.com", 200.00);
  }

  /** @return Specify Bean Type */
  @Override
  public Class<?> getObjectType() {
    return null;
  }

  /** @return whether is singleton */
  @Override
  public boolean isSingleton() {
    return true;
  }
}
