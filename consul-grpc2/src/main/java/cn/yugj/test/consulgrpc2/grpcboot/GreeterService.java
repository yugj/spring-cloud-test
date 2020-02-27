package cn.yugj.test.consulgrpc2.grpcboot;

import cn.yugj.test.consulgrpc2.grpc.stub.GreeterGrpc;
import cn.yugj.test.consulgrpc2.grpc.stub.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.logging.Logger;

/**
 * @author yugj
 * @date 2020/2/25 22:39.
 */
@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    private static final Logger logger = Logger.getLogger(GreeterService.class.getName());

    @Override
    public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {

        logger.info("say hell");

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
