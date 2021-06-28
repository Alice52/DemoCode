package cloud.grpc.server.configuration;

import cloud.grpc.server.interceptor.LogGrpcInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * @author asd <br>
 * @create 2021-06-28 12:59 PM <br>
 * @project boot-security-shiro <br>
 */
@Configuration(proxyBeanMethods = false)
public class ServerConfiguration {

    @GrpcGlobalServerInterceptor
    LogGrpcInterceptor logServerInterceptor() {
        return new LogGrpcInterceptor();
    }
}
