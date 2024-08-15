package com.example.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

//The remote interface marked by extending java.rmi.Remote
//All methods in this interface are available remotely
public interface GreetingService extends Remote {

    String greet(String name) throws RemoteException;
}
