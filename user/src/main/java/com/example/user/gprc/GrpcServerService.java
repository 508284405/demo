package com.example.user.gprc;

import com.example.common.gprc.Hello;
import com.example.common.gprc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(Hello.HelloRequest req, StreamObserver<Hello.HelloResponse> responseObserver) {
        Hello.HelloResponse reply = Hello.HelloResponse.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}