package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            while (true) {
                //used in DatagramPacket to store data received from client
                byte[] buffer = new byte[50];
                //used to store data received from client in the initialized buffer. If the data length is greater than
                //the buffer length, the data is truncated.
                //it is used to create connectionless packets delivery service.
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                //receive data from client. Blocks until data is received. It contains the ip address and port number
                //used on the sender side.
                socket.receive(packet);
                String messageFromClient = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Text received is: " + messageFromClient);

                //echo to the client
                String messageToClient = "Echo: " + messageFromClient;
                byte[] bufferToClient = messageToClient.getBytes();
                //the server gets the ip address and port number of the client from the packet received from the client.
                //this is because udp is connectionless.
                DatagramPacket echoPacket = new DatagramPacket(bufferToClient, bufferToClient.length, packet.getAddress(), packet.getPort());
                socket.send(echoPacket);
            }
        } catch (SocketException e) {
            System.out.println("Socket exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }
}
