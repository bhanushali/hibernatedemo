/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import java.util.Iterator;
import java.util.List;
import org.educate.hibernate.dto.Address;
import org.educate.hibernate.dto.Book;
import org.educate.hibernate.dto.Course;
import org.educate.hibernate.dto.Lecturer;
import org.educate.hibernate.dto.Regular;
import org.educate.hibernate.dto.Student;
import org.educate.hibernate.dto.StudentAcademic;
import org.educate.hibernate.dto.Visiting;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
        
        
        // Working with inheritance
        Lecturer lecturer = new Lecturer();
        lecturer.setName("Anonymous");
        
        Regular khozema  = new Regular();
        khozema.setName("Khozema Nullwala");
        khozema.setSalary(10000.0);
        
        Visiting sudha  = new Visiting();
        sudha.setName("Sudha Singh");
        sudha.setHourlyCharges(1000);
        
        session.persist(lecturer);
        session.persist(khozema);
        session.persist(sudha);
                
        
        // Fetch the details now
        String hql = "FROM Visiting";
        Query query = session.createQuery(hql);
        List<Visiting> visitingLecturers = query.list();
        // using enhanced for loop
        for(Visiting v : visitingLecturers) {
            System.out.println("Visiting Lecturers Name: " +v.getName());
            System.out.println("Visiting Lecturers ID: " +v.getId());
            System.out.println("Visiting Lecturers Hourly Charges: " +v.getHourlyCharges());
        }
        
        hql = "FROM Regular";
        query = session.createQuery(hql);
        
        // using iterator
        for (Iterator<Regular> iterator = query.iterate(); iterator.hasNext();) {
            Regular regular = (Regular)iterator.next();
            System.out.println("Regular Lecturers Name: " +regular.getName());
            System.out.println("Regular Lecturers ID: " +regular.getId());
            System.out.println("Regular Lecturers Salary: " +regular.getSalary());            
        }
        
        
        // using criteria
        Criteria criteria = session.createCriteria(Regular.class);
        criteria.add(Restrictions.eq("name", "Khozema Nullwala"));        
        List<Regular> regularLecturers = criteria.list();
        for(Regular regular : regularLecturers) {
            System.out.println("Regular Lecturers Name: " +regular.getName());
            System.out.println("Regular Lecturers ID: " +regular.getId());
            System.out.println("Regular Lecturers Salary: " +regular.getSalary());            
        }
        
        
        
                               
        tx.commit();
        session.close();
        
        
    }
    
}
