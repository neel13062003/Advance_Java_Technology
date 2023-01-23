/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author HP
 */
public class main {
    public static void main(String[] args) {
        Student s = new Student();
        //s.setId(1);
        s.setName("Neel");
        s.setSem(0);
        
        SessionFactory S = new AnnotationConfiguration().configure().buildSessionFactory();    //S must Capital.
        Session session = S.openSession();
        session.beginTransaction();
        
        session.save(s);
        session.getTransaction().commit();
        session.close();
        S.close();
    }
}
