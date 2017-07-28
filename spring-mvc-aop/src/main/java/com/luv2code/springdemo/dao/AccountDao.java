package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Account;

public interface AccountDao {

    void addAccount();

    void addAccount(Account account);

    boolean isAccount();

    boolean doWork();

    void setAccount(Account account);
}
