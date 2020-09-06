package cn.edu.ntu.javaee.springboot.validation.component;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;

/**
 * @author zack <br>
 * @create 2020-07-29 20:17 <br>
 * @project validation <br>
 */
public class AopTargetUtils {

  /**
   * Get real target object by proxy.
   *
   * @param proxy
   * @return
   * @throws Exception
   */
  public static Object getTarget(Object proxy) throws Exception {
    if (!AopUtils.isAopProxy(proxy)) {
      return proxy;
    }
    if (AopUtils.isJdkDynamicProxy(proxy)) {
      proxy = getJdkDynamicProxyTargetObject(proxy);
    } else {
      proxy = getCglibProxyTargetObject(proxy);
    }
    return getTarget(proxy);
  }

  private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
    Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
    h.setAccessible(true);
    Object dynamicAdvisedInterceptor = h.get(proxy);
    Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
    advised.setAccessible(true);
    Object target =
        ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
    return target;
  }

  private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
    Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
    h.setAccessible(true);
    AopProxy aopProxy = (AopProxy) h.get(proxy);
    Field advised = aopProxy.getClass().getDeclaredField("advised");
    advised.setAccessible(true);
    Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
    return target;
  }
}
