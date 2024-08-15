package com.example.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//This implementation is the Remote Object
public class GreetingServiceImpl extends UnicastRemoteObject implements GreetingService {

    protected GreetingServiceImpl() throws RemoteException {
    }

    @Override
    public String greet(String name) throws RemoteException {
        return String.format("Hello %s!", name);
    }
}
