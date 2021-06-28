package cloud.grpc.client.service;

import cloud.nacos.grpc.api.HelloReply;
import cloud.nacos.grpc.api.HelloRequest;
import cloud.nacos.grpc.api.SimpleGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author asd <br>
 * @create 2021-06-28 12:53 PM <br>
 * @project cloud-grpc-client <br>
 */
@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private SimpleGrpc.SimpleBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response =
                    this.simpleStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
