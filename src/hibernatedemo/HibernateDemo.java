/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import org.educate.hibernate.dto.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MRuser
 */
public class HibernateDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        // first get the sessionFactory object and open a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        // Create a new student object
        Student x = new Student();
        x.setFirstName("Khozema");
        x.setLastName("Nullwala");
        
        session.persist(x);
        
        Student y = new Student();
        y.setFirstName("Ahmed");
        y.setLastName("Qureshi");
        
        session.persist(y);
        
        
        tx.commit();
        session.close();
        
        
    }
    
}
