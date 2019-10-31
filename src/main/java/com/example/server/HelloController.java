package com.example.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
public class HelloController {


    @MessageMapping("hello")
    public Mono<Void> hello(Person person) {
        System.out.println(person.getName());
        System.out.println("Hello");
       return Mono.empty();
    }
    @MessageMapping("greet")
    Mono<GreetingsResponse> greet(GreetingsRequest request) {
        return Mono.just(new GreetingsResponse("Hello " + request.getName() + " @ " + Instant.now()));
    }
}
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
    public Person(){

    }
}

class GreetingsRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GreetingsRequest(String name) {
        this.name = name;
    }
    public GreetingsRequest() {

    }
}



class GreetingsResponse {

    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public GreetingsResponse(String greeting) {
        this.greeting = greeting;
    }
    public GreetingsResponse(){

    }
}