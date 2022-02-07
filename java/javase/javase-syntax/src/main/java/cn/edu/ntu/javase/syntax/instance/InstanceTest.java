package cn.edu.ntu.javase.syntax.instance;

import cn.edu.ntu.javase.common.model.Person;
import cn.edu.ntu.javase.common.model.Student;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
 * @project javase-syntax <br>
 */
@Slf4j
public class InstanceTest {

    @Test
    public void testInstanceOf() {
        assert new Person() instanceof Person;
        assert new Student() instanceof Person;
    }

    @Test
    public void testIsAssignableFrom() {
        assert Person.class.isAssignableFrom(Person.class);
        assert Person.class.isAssignableFrom(Student.class);
    }

    /************************************************
     * // detail
     *************************************************/

    /**
     * The compiler checks whether obj can be converted to the class type correctly. <br>
     * If it cannot be converted, an error is reported directly.<br>
     * If the type cannot be determined, it is compiled success.<br>
     */
    @Test
    public void testInterface() {
        boolean flag = new String() instanceof Comparable;
        Assert.isTrue(flag);
        log.info("interface can be instance template: " + flag);
    }

    @Test
    public void testType() {
        Integer i = new Integer(10);
        boolean flag = i instanceof Integer;
        Assert.isTrue(flag);
        log.info("instance template should be Reference type: " + flag);
    }

    @Test
    public void testNullType() {
        // null is a special symbol that can be any reference type.
        boolean flag = null instanceof Comparable;
        Assert.isFalse(flag);
        log.info("null can be obj, but it will not be any Object instance: " + flag);
    }

    @Test
    public void testExtends() {
        ArrayList arrayList = new ArrayList();
        boolean flag = arrayList instanceof List;
        Assert.isTrue(flag);

        List list = new ArrayList();
        boolean flagB = list instanceof ArrayList;
        Assert.isTrue(flagB);
    }
}
