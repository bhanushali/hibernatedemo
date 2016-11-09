/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import org.educate.hibernate.dto.Address;
import org.educate.hibernate.dto.Book;
import org.educate.hibernate.dto.Course;
import org.educate.hibernate.dto.Student;
import org.educate.hibernate.dto.StudentAcademic;
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
        StudentAcademic x_academic = new StudentAcademic();
        x.setFirstName("Khozema");
        x.setLastName("Nullwala");
        
        x_academic.setRollNo("S170001");
        x_academic.setStudent(x);
        
        x.setAcademic(x_academic);
        
        Address permanent = new Address();
        permanent.setAddressLine1("Amar Jyot Building, 3 / 306");
        permanent.setAddressLine2("Anand Koliwada, Near Railway Crossing");
        permanent.setCity("Thane");
        permanent.setPincode("400612");
        permanent.setState("Maharashtra");
        permanent.setCountry("India");
                
        Address correspondence = new Address();
        correspondence.setAddressLine1("Vianayak Apartment, 2 / 23");
        correspondence.setAddressLine2("Dabolkar Road, Above Zaini Commerce Classes");
        correspondence.setCity("Thane");
        correspondence.setPincode("400612");
        correspondence.setState("Maharashtra");
        correspondence.setCountry("India");

        
        x.setCorrespondence(correspondence);
        x.setPermanent(permanent);
        
        
        // Couple of books instance
        Book b = new Book();
        b.setTitle("Not a penny more not a penny less");
        // setting the student object
        b.setStudent(x);

        Book c = new Book();
        c.setTitle("Like a flowing river");
        // setting the student object
        c.setStudent(x);                
        
        // for bidirectional assign the books to student
        x.getBooks().add(b);
        x.getBooks().add(c);
        
        
        // create instance of course
        Course java = new Course();
        java.setTitle("Core Java Programming");
        
        x.getCourses().add(java);
        
        
        Course cpp = new Course();
        cpp.setTitle("C++ Programming");

        // adding of student for bidirectional
        java.getStudents().add(x);
        cpp.getStudents().add(x);
        
        x.getCourses().add(cpp);
        
        
        // student is persisted here        
        session.persist(java);
        session.persist(cpp);
        session.persist(x);
//        session.persist(b);
//        session.persist(c);
        
                
        tx.commit();
        session.close();
        
        
    }
    
}
