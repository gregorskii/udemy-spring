package com.luv2code.springdemo.services;

import com.luv2code.springdemo.entities.Account;

import java.util.List;

public interface AccountService {

    void addAccount();

    List<Account> findAccounts();
}
