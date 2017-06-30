package com.luv2code.springdemo.models;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private String firstName;
    private String lastName;
    private String grade;
    private String subject;
    private String country;

    public Student() { }

    public Student(
        String theFirstName,
        String theLastName,
        String theGrade,
        String theSubject,
        String theCountry
    ) {
        setFirstName(theFirstName);
        setLastName(theLastName);
        setGrade(theGrade);
        setSubject(theSubject);
        country = theCountry;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
