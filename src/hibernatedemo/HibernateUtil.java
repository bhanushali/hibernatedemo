/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author MRuser
 */
public class HibernateUtil {
    
    private static final  SessionFactory sessionFactory;
    
    static {
        try {
        // read the configuration file 
        Configuration configuration = new Configuration().configure("/hibernatedemo/hibernate.cfg.xml");
        StandardServiceRegistry registry = 
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
        sessionFactory = configuration.buildSessionFactory(registry);                
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            throw new ExceptionInInitializerError("SessionFactory initialization failed!");
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
