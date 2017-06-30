package com.luv2code.springdemo.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Student {

    private String firstName;
    private String lastName;
    private String grade;
    private String subject;
    private String country;
    private String personality;
    private Boolean doingWell;
    private ArrayList<String> favoriteSubjects;

    public Student() { }

    public Student(
        String firstName,
        String lastName,
        String grade,
        String subject,
        String country,
        String personality,
        Boolean doingWell,
        ArrayList<String> favoriteSubjects
    ) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGrade(grade);
        this.setSubject(subject);
        this.setCountry(country);
        this.setPersonality(personality);
        this.setDoingWell(doingWell);
        this.setFavoriteSubjects(favoriteSubjects);
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

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Boolean getDoingWell() {
        return doingWell;
    }

    public void setDoingWell(Boolean doingWell) {
        this.doingWell = doingWell;
    }

    public ArrayList<String> getFavoriteSubjects() {
        return favoriteSubjects;
    }

    public void setFavoriteSubjects(ArrayList<String> favoriteSubjects) {
        this.favoriteSubjects = favoriteSubjects;
    }
}
