/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapf_exp_7;

import java.text.Annotation;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author miraj
 */
public class Main {
    
    public static void main(String[] args) {
        
        Student s = new Student();
        Student_details sd = new Student_details();
        
        s.setName("Kalp");
//        s.setId(1);
        s.setSemester(113);
        sd.setAddress("Gondal");
        sd.setStu(s);
        
        
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        se.save(sd);
        se.getTransaction().commit();
        se.close();
        sf.close();
        
    }
    
}
