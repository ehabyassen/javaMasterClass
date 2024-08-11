package com.udp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(1234)) {
            InetAddress address = InetAddress.getLocalHost();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Enter message: ");
                String message = sc.nextLine();
                if (message.equals("exit")) break;
                byte[] buffer = message.getBytes();
                for (Integer port : getDestinations()) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                    socket.send(packet);
                }
            }
        } catch (SocketException e) {
            System.out.println("Socket exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }

    private static List<Integer> getDestinations() {
        List<Integer> destinations = new ArrayList<>();
        Path path = Paths.get(System.getProperty("user.dir")).getParent();
        File file = new File(path.toString() + "/destinations.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String port;
            while ((port = reader.readLine()) != null) {
                destinations.add(Integer.parseInt(port));
            }
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
        return destinations;
    }
}
