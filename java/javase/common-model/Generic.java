/**
 * @author zack
 * @create 2019-06-14 18:01
 * @function
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public class Generic<T> {
    /**
     * 方法的返回值可以使用前面声明的泛型类型
     */
    public T get() {
        T t = (T) new Person();
        return t;
    }

    /**
     * 方法参数也可以使用声明类时声明的泛型类型
     */
    public void save(T entity) {

    }

    /**
     * 泛型方法1
     * 1.这里的 <T>声明只是为了后面的使用
     */
    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o); // correct
        }
    }


    /**
     * 功能：这里解释上面的E类型的确定
     * 测试代码：pers.test("");  //此时的E为String类型
     * pers.test(new Person("123",12));	//此时的E为Person类型
     */

    public <E> E test(E e) {
        return e;
    }
}
