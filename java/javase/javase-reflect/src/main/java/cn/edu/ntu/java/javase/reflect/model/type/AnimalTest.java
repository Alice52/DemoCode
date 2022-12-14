package cn.edu.ntu.java.javase.reflect.model.type;

import cn.edu.ntu.java.javase.reflect.model.Animal;
import cn.edu.ntu.java.javase.reflect.model.impl.Cat;
import cn.edu.ntu.java.javase.reflect.model.impl.Dog;
import cn.edu.ntu.java.javase.reflect.model.impl.Elephant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author zack <br>
 * @create 2020-04-04 23:57 <br>
 */
@Slf4j
public class AnimalTest {
    private static final Logger LOG = LoggerFactory.getLogger(AnimalTest.class);

    private static final String[] ANIMAL_TYPES =
            new String[] {
                "cn.edu.ntu.javase.reflect.model.impl.Cat",
                "cn.edu.ntu.javase.reflect.model.impl.Dog",
                "cn.edu.ntu.javase.reflect.model.impl.Elephant"
            };

    @Test
    public void testInterfaceImpl() {
        // 需要在 resource 下配置: 实现类
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            log.info("impl: {}", animal);
        }
    }

    @Test
    public void testRTTI() {
        // Know animal type, so create specify class directly.
        // Upward transformation will lost specify type, and just keep interface type
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Elephant());
        animals.add(new Dog());

        // list container contain and only contain Objects,
        // auto transfer to Animal Object
        animals.forEach(Animal::getType);
    }

    @Test
    public void testReflect() {

        Arrays.stream(ANIMAL_TYPES)
                .forEach(
                        type -> {
                            try {
                                Class<?> clz = Class.forName(type);
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
