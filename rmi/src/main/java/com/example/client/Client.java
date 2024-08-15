package com.example.client;

import com.example.server.GreetingService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        /*
         * The 'rmi://localhost:5000/greetingService' url is a way to reference the remote object that has been
         * registered with the RMI registry. It consists of:
         * rmi:// the RMI scheme or protocol.
         * localhost: the hostname where the registry runs.
         * 5000: the registry's port number.
         * greetingService: the name under which the remote object is registered.
        */
        GreetingService service = (GreetingService) Naming.lookup("rmi://localhost:5000/greetingService");
        System.out.println("Service was looked up...");

        System.out.println("Calling the greet method...");
        String greeting = service.greet("Bob");
        System.out.println(greeting);
    }
}
