package com.example.order.service.impl;

import com.example.common.gprc.Hello;
import com.example.common.gprc.HelloServiceGrpc;
import com.example.order.domain.OrderRepository;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @GrpcClient("animals-husbandry-console43")
    private HelloServiceGrpc.HelloServiceBlockingStub greeterStub;

    @Override
    public void list() {
        Hello.HelloRequest request = Hello.HelloRequest.newBuilder().setName("wy").build();
        Hello.HelloResponse response = greeterStub.sayHello(request);
        log.info("get message: {}",response.getMessage());
    }
}
