package boot.webflux.client.component.interfaces;

/**
 * @author zack <br>
 * @create 2021-04-11 16:37 <br>
 * @project springboot <br>
 */
public interface IProxyCreator<E> {

  /**
   * 创建代理对象
   *
   * @param clazz
   * @return
   */
  E createProxy(Class<?> clazz);
}
