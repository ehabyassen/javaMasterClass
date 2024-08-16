package com.example.helloService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from service A.\n";
    }
}
