/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;

public class TestClient {

    public static void main(String[] args) {
        try {
            System.setSecurityManager(new RMISecurityManager());
            Testi tsi = (Testi) Naming.lookup("rmi://localhost:1099/TestServer");
            System.out.println("Result=" + tsi.hello("Raj"));
        } catch (Exception e) {
            System.out.println("Exception occurred" + e);
        }
    }
}
