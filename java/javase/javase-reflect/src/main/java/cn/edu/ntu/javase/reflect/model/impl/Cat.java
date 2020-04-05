package cn.edu.ntu.javase.reflect.model.impl;

import cn.edu.ntu.javase.reflect.model.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 23:50 <br>
 */
public class Cat implements Animal {
  private static final Logger LOG = LoggerFactory.getLogger(Cat.class);

  @Override
  public String getType() {
    final String name = "Cat";
    LOG.info("get animal type: {}", name);
    return name;
  }
}
