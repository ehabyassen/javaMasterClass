package com.example.helloConsumerService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceBController {

    @Value("${service.a.url}")
    private String serviceAUrl;

    private final RestTemplate restTemplate;

    public ServiceBController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consume")
    public String consumerServiceA() {
        String response = restTemplate.getForObject(serviceAUrl + "/hello", String.class);
        return "Response from service A: " + response;
    }
}
