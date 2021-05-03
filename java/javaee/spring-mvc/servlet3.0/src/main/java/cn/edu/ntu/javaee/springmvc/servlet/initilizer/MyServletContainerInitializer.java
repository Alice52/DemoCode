package cn.edu.ntu.javaee.springmvc.servlet.initilizer;

import cn.edu.ntu.javaee.springmvc.servlet.filter.CustomFilter;
import cn.edu.ntu.javaee.springmvc.servlet.listener.CustomListener;
import cn.edu.ntu.javaee.springmvc.servlet.service.IHelloService;
import cn.edu.ntu.javaee.springmvc.servlet.service.impl.HelloService;
import cn.edu.ntu.javaee.springmvc.servlet.servlet.CustomServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

/**
 * 容器启动的时候会将 @HandlesTypes 指定的这个类型下面的子类[实现类,子接口等]传递过来; 传入感兴趣的类型; <br>
 * this class function is same as web.xml, can register bean,such as Listener, Filer, Servlet <br>
 *
 * @author zack <br>
 * @create 2020-05-03 17:23 <br>
 */
@HandlesTypes(value = {IHelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动的时候，会运行onStartup方法；
     *
     * <p>Set<Class<?>> claz：感兴趣的类型的所有子类型； ServletContext
     * arg1:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     *
     * <p>1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
     * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件； 必须在项目启动的时候来添加；
     * 1）、ServletContainerInitializer得到的ServletContext； 2）、ServletContextListener得到的ServletContext；
     */
    @Override
    public void onStartup(Set<Class<?>> claz, ServletContext sc) throws ServletException {

        Optional.ofNullable(claz).ifPresent(x -> claz.stream().forEach(System.out::println));

        // 注册组件  ServletRegistration
        ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", new CustomServlet());
        // 配置servlet的映射信息
        servlet.addMapping("/custom");

        // 注册Listener
        sc.addListener(CustomListener.class);

        // 注册Filter  FilterRegistration
        FilterRegistration.Dynamic filter = sc.addFilter("customFilter", CustomFilter.class);
        filter.setAsyncSupported(true);
        // 配置Filter的映射信息
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
