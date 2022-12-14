package cn.edu.ntu.java.javase.generic;

import lombok.SneakyThrows;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/**
 * Generic class with generic method and generic interface.
 *
 * @author zack <br>
 * @create 2020-04-04 22:51 <br>
 */
public abstract class BaseGenericMethod<T> {

    public static <A extends Comparable<A>> A max(Collection<A> xs) {
        Iterator<A> xi = xs.iterator();
        A w = xi.next();
        while (xi.hasNext()) {
            A x = xi.next();
            if (w.compareTo(x) < 0) {
                w = x;
            }
        }
        return w;
    }

    /**
     * Generate class
     *
     * <pre>
     *    1. requirement:
     *      - must be sub class: `public class GenericImpl extends BaseGeneric<Person>{}`
     * </pre>
     *
     * @return
     */
    public T produce() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];

        return createInstance(clazz);
    }

    @SneakyThrows
    public T createInstance(Class<T> clazz) {

        return clazz.newInstance();
    }

    /**
     * Get Object Hash.
     *
     * @return
     */
    public abstract int hash();
}
