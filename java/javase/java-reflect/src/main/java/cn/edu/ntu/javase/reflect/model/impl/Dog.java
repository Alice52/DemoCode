package cn.edu.ntu.javase.reflect.model.impl;

import cn.edu.ntu.javase.reflect.model.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-02-10 15:08 <br>
 */
public class Dog implements Animal {
  private static final Logger LOG = LoggerFactory.getLogger(Dog.class);

  @Override
  public String getType() {
    final String name = "Dog";
    LOG.info("get animal type: {}", name);
    return name;
  }
}
