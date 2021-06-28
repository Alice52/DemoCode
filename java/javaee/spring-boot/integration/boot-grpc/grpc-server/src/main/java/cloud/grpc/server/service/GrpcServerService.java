package cloud.grpc.server.service;

import cloud.nacos.grpc.api.HelloReply;
import cloud.nacos.grpc.api.HelloRequest;
import cloud.nacos.grpc.api.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author asd <br>
 * @create 2021-06-28 1:00 PM <br>
 * @project boot-security-shiro <br>
 */
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
