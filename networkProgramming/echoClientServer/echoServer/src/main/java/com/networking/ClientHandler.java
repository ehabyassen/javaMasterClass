package com.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;
    private final int clientNum;

    public ClientHandler(Socket clientSocket, int clientNum) {
        this.clientSocket = clientSocket;
        this.clientNum = clientNum;
    }

    @Override
    public void run() {
        // the input stream used to receive data from the client socket
        try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             // the output stream used to send data to the client
             // the autoFlush: true allows the output stream to be flushed automatically
             PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {
            while (true) {
                String messageFromClient = input.readLine();
                if (messageFromClient == null || messageFromClient.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected: " + clientSocket.getInetAddress());
                    break;
                }
                System.out.println("Client [" + clientNum + "] " + messageFromClient);
                String messageToClient = "Echo from server - " + messageFromClient;
                output.println(messageToClient);
            }
        } catch (IOException e) {
            System.out.println("ClientHandler exception: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error while closing clientSocket: " + e.getMessage());
            }
        }
    }
}
