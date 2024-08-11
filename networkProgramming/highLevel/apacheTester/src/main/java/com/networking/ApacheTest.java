package com.networking;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ApacheTest {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest getRequest = HttpRequest.newBuilder(URI.create("https://www.example.org"))
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(getRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Request sent...");

        responseFuture.thenAccept(response -> {
            System.out.println(response.statusCode());
            System.out.println(response.body());
        });
        responseFuture.join();
    }
}
