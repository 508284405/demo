package com.example.user.gprc;

import io.grpc.stub.StreamObserver;

public class GreeterGrpc {
    static class GreeterImplBase{
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {

        }
    }
}