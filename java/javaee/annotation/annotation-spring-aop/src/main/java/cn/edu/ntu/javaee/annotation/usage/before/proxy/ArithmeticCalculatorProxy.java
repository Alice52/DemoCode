package cn.edu.ntu.javaee.annotation.usage.before.proxy;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zack
 * @create 2019-10-28 21:48
 * @function generate proxy object
 */
@Slf4j
public class ArithmeticCalculatorProxy {

    private IArithmeticCalculator targetCalculator;

    public ArithmeticCalculatorProxy(IArithmeticCalculator calculator) {
        this.targetCalculator = calculator;
    }

    public Object getProxy() {

        // for proxy object load
        ClassLoader loader = targetCalculator.getClass().getClassLoader();
        // tell me what function the proxy object have,
        // means let the target and proxy expose same method
        Class<?>[] interfaces = targetCalculator.getClass().getInterfaces();
        Object proxyObject =
                Proxy.newProxyInstance(
                        loader,
                        interfaces,
                        (proxy, method, args) -> {
                            // proxy is the proxy object, but fewer use
                            log.info(
                                    "The method {} begins with {}",
                                    method.getName(),
                                    Arrays.asList(args));
                            Object result = method.invoke(targetCalculator, args);
                            log.info("The method {} ends with [{}]", method.getName(), result);
                            return result;
                        });

        return proxyObject;
    }

    //  /** mock up Proxy work */
    //  class $Proxy0 extends Proxy implements ArithmeticCalculator {
    //
    //    /**
    //     * Constructs a new {@code Proxy} instance from a subclass (typically, a dynamic proxy
    // class)
    //     * with the specified value for its invocation handler.
    //     *
    //     * @param h the invocation handler for this proxy instance
    //     * @throws NullPointerException if the given invocation handler, {@code h}, is {@code
    // null}.
    //     */
    //    protected $Proxy0(InvocationHandler h) {
    //      super(h);
    //    }
    //
    //    private Method METHOD_NAME;
    //
    //    @Override
    //    public int add(int a, int b) throws Throwable {
    //      return (int) h.invoke(this, METHOD_NAME, new Object[] {a, b});
    //    }
    //
    //    @Override
    //    public int sub(int a, int b) {
    //      return 0;
    //    }
    //
    //    @Override
    //    public int mul(int a, int b) {
    //      return 0;
    //    }
    //
    //    @Override
    //    public int div(int a, int b) {
    //      return 0;
    //    }
    //  }
}
