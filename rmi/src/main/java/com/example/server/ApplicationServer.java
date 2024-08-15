package com.example.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.out.println("Server started...");

        Registry registry = LocateRegistry.createRegistry(5000);
        System.out.println("Registry created...");

        registry.bind("greetingService", new GreetingServiceImpl());
        System.out.println("Remote object is bound...");
    }
}
