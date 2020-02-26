package cn.yugj.test.grpcboot;

import cn.yugj.test.grpc.stub.GreeterGrpc;
import cn.yugj.test.grpc.stub.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.logging.Logger;

/**
 * @author yugj
 * @date 2020/2/25 22:39.
 */
@GRpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    private static final Logger log = Logger.getGlobal();
    @Override
    public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {

        log.info("say hell");

        final HelloWorldProto.HelloReply.Builder replyBuilder =
                HelloWorldProto.HelloReply.newBuilder()
                        .setMessage("Hello " + request.getName());

        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();

    }

    @Override
    public void sayHelloAgain(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        super.sayHelloAgain(request, responseObserver);
    }
}
