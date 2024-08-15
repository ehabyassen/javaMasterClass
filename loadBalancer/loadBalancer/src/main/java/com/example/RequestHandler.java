package com.example;

import com.example.utils.RoundRobinHostIPSupplier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {

    private final Socket clientSocket;

    public RequestHandler(Socket socket) {
        clientSocket = socket;
    }

    @Override
    public void run() {
        //client to load balancer connection
        try (InputStream clientToLoadBalancerInputStream = clientSocket.getInputStream();
            OutputStream loadBalancerToClientOutputStream = clientSocket.getOutputStream()) {

            String host = RoundRobinHostIPSupplier.getHost();
            System.out.println("Selected host: " + host);

            //load balancer to servers connection
            try (Socket serverSocket = new Socket(host, 8080);
                InputStream serverToLoadBalancerInputStream = serverSocket.getInputStream();
                OutputStream loadBalancerToServerOutputStream = serverSocket.getOutputStream()) {

                Thread clientDataHandler = new Thread(() -> {
                    try {
                        transferData(clientToLoadBalancerInputStream, loadBalancerToServerOutputStream);
                    } catch (IOException e) {
                        System.err.println("Client Data Handler: " + e.getMessage());
                    }
                });

                Thread serverDataHandler = new Thread(() -> {
                    try {
                        transferData(serverToLoadBalancerInputStream, loadBalancerToClientOutputStream);
                    } catch (IOException e) {
                        System.err.println("Server Data Handler: " + e.getMessage());
                    }
                });

                clientDataHandler.start();
                serverDataHandler.start();

                // Ensure both threads complete before closing resources
                clientDataHandler.join();
                serverDataHandler.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void transferData(InputStream input, OutputStream output) throws IOException {
        int data;
        try {
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        } catch (IOException e) {
            if (!"Socket closed".equals(e.getMessage())) {
                throw e;
            }
        }
    }
}
