package cn.edu.ntu.javase.syntax;

import cn.edu.ntu.javase.common.model.Person;
import org.junit.Test;

/**
 * isAssignableFrom/instanceof
 *
 * <pre>
 *   1. 判断角度
 *      - isAssignableFrom() 方法是从类继承的角度去判断
 *      - instanceof 关键字是从实例继承的角度去判断
 *   2. 判断关系
 *      - isAssignableFrom() 方法是判断是否为某个类的父类或自身
 *      - instanceof 关键字是判断是否某个类的子类或自身
 *
 *   3. usage: https://blog.csdn.net/qq_36666651/article/details/81215221
 *      - 父类.class.isAssignableFrom(子类.class)
 *      - 子类实例 instanceof 父类类型
 * </pre>
 *
 * @author zack <br>
 * @create 2021-06-01 14:07 <br>
 * @project javase <br>
 */
public class InstanceTest {

    @Test
    public void testInstanceOf() {
        assert new Person() instanceof Person;
    }

    @Test
    public void testIsAssignableFrom() {
        assert Person.class.isAssignableFrom(Person.class);
    }
}
