package cloud.grpc.client.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-06-28 12:53 PM <br>
 * @project cloud-grpc-client <br>
 */
@Slf4j
public class LogGrpcInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        log.info(method.getFullMethodName());
        return next.newCall(method, callOptions);
    }
}
