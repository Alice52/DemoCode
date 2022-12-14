package cn.edu.ntu.java.javase.reflect;

import cn.edu.ntu.java.javase.common.model.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zack <br>
 * @create 2020-04-04 23:45 <br>
 */
public class ReflectAndGeneric {
    /**
     * 功能：测试泛型：非常重要 <br>
     * 1.获取泛型参数的类型：在Dao的Constructor中<br>
     */
    @Test
    public void testGeneral() throws Exception {
        PersonDao personDao = new PersonDao();
        Person entity = new Person("zack", 12);
        personDao.save(entity);
        Person man = personDao.get();
        System.out.println(man);
    }

    /**
     * 功能：测试getSupperClassGenericType(clazz,)<br>
     *
     * @throws Exception
     */
    @Test
    public void testGeneral2() throws Exception {
        Class<?> clazz = PersonDao.class;
        Class<?> argsClass = ReflectionUtils.getSupperClassGenericType(clazz, 0);
        System.out.println(argsClass);
        Class<?> argsClass2 = ReflectionUtils.getSupperClassGenericType(clazz, 1);
        System.out.println(argsClass2);
    }
}

/**
 * 构造器的调用顺序：先调用父类的构造器，再调用子类的构造器<br>
 */
class Dao<T, PK> {
    private Class<T> clazz;

    /**
     * 功能：Dao的Constructor：<br>
     * 1.得到泛型参数T：<br>
     * 1.1 获取带有泛型的类的 Class对象:这里必须是有子类的(确定了T的类型)，因为不可以获取本身的泛型：没有意义<br>
     * 1.2 想办法获取泛型参数：Type type=this.getClass().getGenericSuperclass();<br>
     * 1.2.1 若是带参数的 type,进行强制转换：ParameterizedType parameterizedType=(ParameterizedType) type;<br>
     * 1.2.2 获取实际参数数组的第一个元素，为泛型 T 的类型<br>
     */
    public Dao() {
        // 1. 获取Dao子类的父类：就是获取Dao本身
        this.getClass().getSuperclass();
        // 2. 获取带参数的Dao子类的父类：就是获取Dao<T>本身
        // Type类型的
        Type type = this.getClass().getGenericSuperclass();
        // 3. 想办法获取参数T
        if (type instanceof ParameterizedType) {
            // 3.1 若是带参数的type,进行强制转换
            ParameterizedType parameterizedType = (ParameterizedType) type;
            // 3.2 获取实际参数数组
            Type[] args = parameterizedType.getActualTypeArguments();

            if (args != null && args.length > 0) {
                // 3.3若是其中args不为null,则获取第一个参数(是Class<T>),并将其付给clazz变量
                clazz = (Class<T>) args[0];
            }
        }
    }

    public T get() throws Exception {
        T t = this.clazz.newInstance();
        return t;
    }

    public void save(T entity) {
        System.out.println("save: " + entity);
    }
}

class PersonDao extends Dao<Person, String> {
    public PersonDao() {
        System.out.println("145");
    }
}
