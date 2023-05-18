package com.example.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class DemoResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String hostName = exchange.getRequest().getRemoteAddress().getHostName();
        String path = exchange.getRequest().getPath().value();
        log.info("hostName:{}，path:{}", hostName, path);
        return Mono.just(path + hostName);
    }
}