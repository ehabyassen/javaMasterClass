package com.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        System.out.println("Connecting to server...");
        // The created socket is the connection to the server. It is used to send and receive data between
        // the client and the server.
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            System.out.println("Connected to server...");
            // input stream used to receive data from the server
            try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 // output stream used to send data to the server
                 PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                 Scanner sc = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Client: ");
                    String messageToServer = sc.nextLine();
                    output.println(messageToServer);
                    if (messageToServer.equals("exit")) break;
                    String messageFromServer = input.readLine();
                    System.out.println("Server: " + messageFromServer);
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Socket timed out: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}
