package com.luv2code.springdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING STUFF: ADDING A MEMBERSHIP ACCOUNT.");
    }

    @Override
    public void goToSleep() {
        System.out.println("GOING TO SLEEP");
    }
}
