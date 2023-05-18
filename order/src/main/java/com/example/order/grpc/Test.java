package com.example.order.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @GrpcClient("gRPC server name")
    private GreeterGrpc.GreeterBlockingStub greeterStub;
}
