package cn.edu.ntu.javase.reflect.type;

import cn.edu.ntu.javase.reflect.model.Animal;
import cn.edu.ntu.javase.reflect.model.impl.Cat;
import cn.edu.ntu.javase.reflect.model.impl.Dog;
import cn.edu.ntu.javase.reflect.model.impl.Elephant;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-04-04 23:57 <br>
 */
public class AnimalTest {
  private static final Logger LOG = LoggerFactory.getLogger(AnimalTest.class);

  private static final String[] ANIMAL_TYPES =
      new String[] {
        "cn.edu.ntu.javase.reflect.model.impl.Cat",
        "cn.edu.ntu.javase.reflect.model.impl.Dog",
        "cn.edu.ntu.javase.reflect.model.impl.Elephant"
      };

  @Test
  public void testRTTI() {
    // Know animal type, so create specify class directly.
    // Upward transformation will lost specify type, ans just keep interface type
    List<Animal> animals = new ArrayList<>();
    animals.add(new Cat());
    animals.add(new Elephant());
    animals.add(new Dog());

    // list container contain and only contain Objects,
    // auto transfer to Animal Object
    animals.stream().forEach(animal -> animal.getType());
  }

  @Test
  public void testReflect() {

    Arrays.stream(ANIMAL_TYPES)
        .forEach(
            type -> {
              try {
                Class clz = Class.forName(type);
                Object object = clz.newInstance();

                Method getTypeMethod = Animal.class.getMethod("getType");
                getTypeMethod.invoke(object);

              } catch (Exception e) {
                LOG.warn(
                    "Get Class or create instance by type name: {} failed: {}",
                    type,
                    e.getMessage());
              }
            });
  }
}
