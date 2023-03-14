/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestServer extends UnicastRemoteObject implements Testi {

    public TestServer() throws RemoteException {
    }

    public String hello(String hello) throws RemoteException {
        return "Server says " + hello;
    }

    public static void main(String[] args) {
        try {
            TestServer tso = new TestServer();
            Naming.rebind("rmi://localhost:1099/TestServer", tso);
        } catch (Exception e) {
            System.out.println("Exception occurred" + e);
        }
    }

}
