package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.entities.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LandingController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    public String index() {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        // CREATE

        // Student student =  new Student(
        //     "Paul",
        //     "Wall",
        //     "paul.wall@example.com"
        // );

        // session.beginTransaction();
        // session.save(student);
        // session.getTransaction().commit();

        // RETRIEVE

        // session.beginTransaction();
        // Student student =  session.get(Student.class, "15");
        // // session.getTransaction().commit();
        //
        // if (student != null) {
        //     System.out.println(student.toString());
        // } else {
        //     System.out.println("No student found");
        // }
        //
        // // UPDATE
        //
        // student.setEmail("test@gmail.com");
        //
        // // These are not needed as any change to a committed object will persist
        // // on the next commit, assuming the transaction is still open
        // // session.beginTransaction();
        // // session.save(student);
        // session.getTransaction().commit();

        // UPDATE ALL

        // session.beginTransaction();
        // session.createQuery("update Student set email='testing@testing.com'").executeUpdate();
        // session.getTransaction().commit();

        // QUERY

        // List<Student> students = session.createQuery("from Student").list();
        // List<Student> students = session.createQuery("from Student s where s.id ='16'").list();
        //
        // System.out.println(students);

        // DELETE

        // With objects
        // session.beginTransaction();
        // Student student =  session.get(Student.class, "15");
        // session.delete(student);
        // session.getTransaction().commit();

        // With query
        // session.beginTransaction();
        // session.createQuery("delete from Student s where s.id ='16'").executeUpdate();
        // session.getTransaction().commit();

        return "index/index";
    }
}