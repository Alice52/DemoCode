package cn.edu.ntu.java.declare.dynamic;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author alice2
 */
public class SetValue {

    /**
     * 在每一个类执行之前, 设置注解的属性
     *
     * @throws NoSuchFieldException if any
     * @throws IllegalAccessException if any
     */
    @BeforeClass
    @SneakyThrows
    @SuppressWarnings("unchecked")
    public static void beforeClass() {
        Method method = SetValue.class.getMethod("tag");

        Tag tag = method.getAnnotation(Tag.class);
        InvocationHandler h = Proxy.getInvocationHandler(tag);
        Field hField = h.getClass().getDeclaredField("memberValues");
        hField.setAccessible(true);
        Map memberMethods = (Map) hField.get(h);

        memberMethods.put("value", "setAnnotation");
        String value = tag.value();
        Assert.assertEquals("setAnnotation", value);
    }

    @SneakyThrows
    public static void main(String[] args) {
        beforeClass();
    }

    @Tag
    public void tag() {}
}
