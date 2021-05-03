package cn.edu.ntu.javase.reflect.spi;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * add config in follow location: META-INF/services/cn.edu.ntu.javase.reflect.spi <br>
 *
 * <p>cn.edu.ntu.javase.reflect.spi.HandlerImpl1 <br>
 *
 * <p>cn.edu.ntu.javase.reflect.spi.HandlerImpl2 <br>
 *
 * @author zack <br>
 * @create 2020-02-10 23:30 <br>
 */
public class SpiUsageTest {

    public static void main(String... args) {
        // use SPI load plugin
        List<Object> handlers = new ArrayList<>();

        ServiceLoader<Handler> serviceLoader = ServiceLoader.load(Handler.class);
        Iterator<Handler> handlerIterator = serviceLoader.iterator();
        while (handlerIterator.hasNext()) {
            Handler handler = handlerIterator.next();
            handlers.add(handler);
        }
        // Assemble the loaded plugin into an InvocationHandler for distribution processing
        DispatcherInvocationHandler invocationHandler = new DispatcherInvocationHandler(handlers);
        // generate proxy object
        Handler proxy =
                (Handler)
                        Proxy.newProxyInstance(
                                DispatcherInvocationHandler.class.getClassLoader(),
                                new Class[] {Handler.class},
                                invocationHandler);
        // call handle method
        proxy.handle("Test");
    }
}
