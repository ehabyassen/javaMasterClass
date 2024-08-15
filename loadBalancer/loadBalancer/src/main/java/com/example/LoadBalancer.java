package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoadBalancer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket loadBalancerSocket = new ServerSocket(8081)) {
            System.out.println("LoadBalancer Started at port 8081...");
            //accepting connections from clients
            while (true) {
                Socket clientSocket = loadBalancerSocket.accept();
                System.out.println("TCP Connection established with client " + clientSocket.toString());
                Thread t = new Thread(new RequestHandler(clientSocket));
                t.start();
            }
        }
    }
}
