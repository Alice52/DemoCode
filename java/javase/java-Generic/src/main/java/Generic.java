import java.util.Collection;

/**
 * @author zack<br>
 * @create 2020-01-31 11:52<br>
 */
public class Generic<T> {
  /**
   * 方法的返回值可以使用前面声明的泛型类型
   */
  public T get() {
    T t = (T) new Person();
    return t;
  }

  /** 方法参数也可以使用声明类时声明的泛型类型 */
  public void save(T entity) {}

  /**
   * 泛型方法
   *    1 1.这里的 <T>声明只是为了后面的使用
   **/
  public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
    for (T o : a) {
      // correct
      c.add(o);
    }
  }

  /**
   * 功能：这里解释上面的E类型的确定
   *    测试代码：
   *    pers.test("");  //此时的E为String类型 pers.test(new Person("123",12));
   *                    //此时的E为Person类型
   */
  public <E> E test(E e) {
    return e;
  }
}
