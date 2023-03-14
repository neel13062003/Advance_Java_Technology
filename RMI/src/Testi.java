/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;

/**
 *
 * @author MAHADEV
 */
public interface Testi extends Remote {
    public String hello(String hello) throws RemoteException;
}
