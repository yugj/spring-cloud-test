package cn.yugj.test.consulgrpc2.grpcboot;

import cn.yugj.test.consulgrpc2.grpc.stub.GreeterGrpc;
import cn.yugj.test.consulgrpc2.grpc.stub.HelloWorldProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author yugj
 * @date 2020/2/27 23:56.
 */
@Service
public class GreeterClient {

    @GrpcClient("consul-grpc2")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    public void hell() {
        final HelloWorldProto.HelloRequest helloRequest = HelloWorldProto.HelloRequest.newBuilder().setName("Bob").build();
        greeterStub.sayHello(helloRequest);
    }
}
