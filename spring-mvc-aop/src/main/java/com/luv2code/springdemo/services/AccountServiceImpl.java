package com.luv2code.springdemo.services;

import com.luv2code.springdemo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(
        AccountDao accountDao
    ) {
        this.accountDao = accountDao;
    }

    @Override
    public void addAccount() {
        accountDao.addAccount();
    }
}
