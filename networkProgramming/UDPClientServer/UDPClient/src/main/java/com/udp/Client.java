package com.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getLocalHost();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Enter message: ");
                String message = sc.nextLine();
                if (message.equals("exit")) break;
                byte[] buffer = message.getBytes();
                //the packet is self-contained because it contains the ip address and port number of the receiver.
                //multiple packets sent from one machine to another can be routed in a different way.
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                socket.send(packet);

                //receive echo from server
                byte[] bufferFromServer = new byte[50];
                DatagramPacket packetFromServer = new DatagramPacket(bufferFromServer, bufferFromServer.length);
                socket.receive(packetFromServer);
                String messageFromServer = new String(bufferFromServer, 0, packetFromServer.getLength());
                System.out.println("\033[0;31m" + messageFromServer + "\033[0m");
            }
        } catch (SocketException e) {
            System.out.println("Socket exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }
}
