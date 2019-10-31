package com.example.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class HelloController {


    @MessageMapping("hello")
    public Mono<Void> hello(String str) {
        System.out.println(str);
        return Mono.empty();
    }
}