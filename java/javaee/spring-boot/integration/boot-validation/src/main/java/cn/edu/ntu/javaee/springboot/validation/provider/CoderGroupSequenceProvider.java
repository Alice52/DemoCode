package cn.edu.ntu.javaee.springboot.validation.provider;

import cn.edu.ntu.javaee.springboot.validation.vo.Coder;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-08-02 12:26 <br>
 * @project validation <br>
 */
public class CoderGroupSequenceProvider implements DefaultGroupSequenceProvider<Coder> {

  private static final int PRIMARY_MIN = 20;
  private static final int PRIMARY_MAX = 25;
  private static final int MIDDLE_MAX = 30;

  @Override
  public List<Class<?>> getValidationGroups(Coder object) {

    List<Class<?>> defaultGroups = new ArrayList<>();
    defaultGroups.add(Coder.class);

    if (null == object || null == object.getAge()) {
      return defaultGroups;
    }

    if (PRIMARY_MIN <= object.getAge() && object.getAge() < PRIMARY_MAX) {
      defaultGroups.add(Coder.PrimaryCoder.class);
    } else if (PRIMARY_MAX <= object.getAge() && object.getAge() < MIDDLE_MAX) {
      defaultGroups.add(Coder.MiddleCoder.class);
    }

    return defaultGroups;
  }
}
