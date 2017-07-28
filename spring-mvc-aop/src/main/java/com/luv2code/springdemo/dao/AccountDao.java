package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Account;

import java.util.List;

public interface AccountDao {

    void addAccount();

    void addAccount(Account account);

    boolean isAccount();

    boolean doWork();

    void setAccount(Account account);

    List<Account> findAccounts();

    void runException() throws Exception;
}
