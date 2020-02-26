package consulgrpcclient;

import consulgrpcclient.stub.GreeterGrpc;
import consulgrpcclient.stub.HelloWorldProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author yugj
 * @date 2020/2/26 17:12.
 */
@Service
public class GrpcClientService2 {

    /**
     * net.devh grpc 集成 负载均衡
     */
    @GrpcClient("grpc-consul-grpc")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    public void sayHell() {

        final HelloWorldProto.HelloRequest helloRequest = HelloWorldProto.HelloRequest.newBuilder().setName("Bob").build();
        greeterStub.sayHello(helloRequest);

    }
}
