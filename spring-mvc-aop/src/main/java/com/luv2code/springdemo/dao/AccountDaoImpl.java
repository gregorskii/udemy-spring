package com.luv2code.springdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void addAccount() {
        System.out.println("DOING DB WORK: ADDING AN ACCOUNT");
    }
}
