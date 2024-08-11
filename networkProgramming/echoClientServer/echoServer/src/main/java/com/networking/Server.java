package com.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int clientNum = 0;
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                // The call to serverSocket.accept method will return a socket that will be used to communicate with a
                // client. The call to accept() will block until a connection request is received to connect
                // to the server or an exception occurs.
                // The returned socket represents the connection to the client. It is used to send and receive data between
                // the client and the server.
                // The call to accept must always be called from a separate thread or in a non-blocking manner.
                System.out.println("The server is waiting for a client to connect...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                clientSocket.setSoTimeout(5000);
                new Thread(new ClientHandler(clientSocket, ++clientNum)).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}
