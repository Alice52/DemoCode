package cloud.grpc.nacos.controller;

import cloud.grpc.nacos.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author asd <br>
 * @create 2021-06-28 12:52 PM <br>
 * @project cloud-grpc-client <br>
 */
@RestController
public class GrpcClientController {

    @Autowired private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name) {
        return grpcClientService.sendMessage(name);
    }
}
