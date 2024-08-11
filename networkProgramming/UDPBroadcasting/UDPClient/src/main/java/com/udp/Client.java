package com.udp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Client {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            registerPort(socket.getLocalPort());
            while (true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println(new String(packet.getData(), 0, packet.getLength()));
            }
        } catch (SocketException e) {
            System.out.println("Socket exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }

    private static void registerPort(int port) {
        Path path = Paths.get(System.getProperty("user.dir")).getParent();
        File file = new File(path.toString() + "/destinations.txt");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            writer.println(port);
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }
}
