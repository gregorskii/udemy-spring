package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.entities.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

        Student student =  new Student(
            "Paul",
            "Wall",
            "paul.wall@example.com"
        );

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        return "index/index";
    }
}