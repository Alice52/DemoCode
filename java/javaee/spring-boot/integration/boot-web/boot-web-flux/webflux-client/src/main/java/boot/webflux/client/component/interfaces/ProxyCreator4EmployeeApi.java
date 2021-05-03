package boot.webflux.client.component.interfaces;

import boot.webflux.client.annotation.ApiServer;
import boot.webflux.client.api.EmployeeApi;
import boot.webflux.client.common.beans.MethodInfo;
import boot.webflux.client.common.beans.ServerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zack <br>
 * @create 2021-04-11 16:41 <br>
 * @project springboot <br>
 */
@Slf4j
@Component
public class ProxyCreator4EmployeeApi implements IProxyCreator<EmployeeApi> {

    @Resource private IRestHandler handler;

    @Override
    public EmployeeApi createProxy(Class<?> clazz) {

        ServerInfo info = extraServerInfo(clazz);
        handler.initServerInfo(info);

        return (EmployeeApi)
                Proxy.newProxyInstance(
                        this.getClass().getClassLoader(),
                        new Class[] {clazz},
                        (proxy, method, args) -> handler.invokeRest(extraMethodInfo(method, args)));
    }

    private MethodInfo extraMethodInfo(Method method, Object[] args) {

        MethodInfo methodInfo = new MethodInfo();
        setMethod(method, methodInfo);
        methodInfo.setParams(getParamsMap(method, args, methodInfo));
        methodInfo.setIsFlux(method.getReturnType().isAssignableFrom(Flux.class));

        Class<?> clzz =
                (Class<?>)
                        ((ParameterizedType) method.getGenericReturnType())
                                .getActualTypeArguments()[0];
        methodInfo.setReturnType(clzz);

        log.info("method info: {}", methodInfo);
        return methodInfo;
    }

    private void setMethod(Method method, MethodInfo methodInfo) {
        Optional.ofNullable(method.getAnnotations())
                .ifPresent(
                        x ->
                                Stream.of(x)
                                        .forEach(
                                                a -> {
                                                    if (a instanceof GetMapping) {
                                                        methodInfo.setUri(
                                                                ((GetMapping) a).value()[0]);
                                                        methodInfo.setMethod(HttpMethod.GET);
                                                    } else if (a instanceof PostMapping) {
                                                        methodInfo.setUri(
                                                                ((PostMapping) a).value()[0]);
                                                        methodInfo.setMethod(HttpMethod.POST);

                                                    } else if (a instanceof DeleteMapping) {
                                                        methodInfo.setUri(
                                                                ((DeleteMapping) a).value()[0]);
                                                        methodInfo.setMethod(HttpMethod.DELETE);

                                                    } else if (a instanceof PutMapping) {
                                                        methodInfo.setUri(
                                                                ((PutMapping) a).value()[0]);
                                                        methodInfo.setMethod(HttpMethod.PUT);
                                                    }
                                                }));
    }

    private LinkedHashMap<String, Object> getParamsMap(
            Method method, Object[] args, MethodInfo methodInfo) {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
        Optional.ofNullable(method.getParameters())
                .ifPresent(
                        x -> {
                            for (int i = 0; i < x.length; i++) {
                                int finalI = i;
                                Optional.ofNullable(x[i].getAnnotation(PathVariable.class))
                                        .ifPresent(y -> hashMap.put(y.value(), args[finalI]));

                                Optional.ofNullable(x[i].getAnnotation(RequestBody.class))
                                        .ifPresent(
                                                y -> {
                                                    methodInfo.setBody((Mono<?>) args[finalI]);
                                                    ParameterizedType parameterizedType =
                                                            (ParameterizedType)
                                                                    x[finalI]
                                                                            .getParameterizedType();
                                                    methodInfo.setBodyType(
                                                            (Class<?>)
                                                                    parameterizedType
                                                                            .getActualTypeArguments()[
                                                                            0]);
                                                });
                            }
                        });
        return hashMap;
    }

    /**
     * 根据需要创建的代理类的注解获取服务器信息
     *
     * @param clazz
     * @return
     */
    private ServerInfo extraServerInfo(Class<?> clazz) {

        ServerInfo info = new ServerInfo();
        Optional.ofNullable(clazz.getAnnotation(ApiServer.class))
                .ifPresent(x -> info.uri("http://" + x.value()));

        log.info("server info: {}", info);
        return info;
    }
}
