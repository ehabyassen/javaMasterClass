package com.example.simpleWebService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String greet() throws IOException {
        URL url = new URL("http://checkip.amazonaws.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String ipAddress = reader.readLine();
        return "Hello from [" + ipAddress + "] at [" + LocalDateTime.now() + "]\n";
    }
}
