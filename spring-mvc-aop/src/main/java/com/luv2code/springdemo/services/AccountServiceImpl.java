package com.luv2code.springdemo.services;

import com.luv2code.springdemo.dao.AccountDao;
import com.luv2code.springdemo.dao.MembershipDao;
import com.luv2code.springdemo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    private MembershipDao membershipDao;

    @Autowired
    public AccountServiceImpl(
        AccountDao accountDao,
        MembershipDao membershipDao
    ) {
        this.accountDao = accountDao;
        this.membershipDao = membershipDao;
    }

    @Override
    public void addAccount() {
        Account account = new Account("Gold", "Greg");
        accountDao.addAccount(account);
        membershipDao.addAccount();
        accountDao.setAccount(account);
        accountDao.isAccount();
        accountDao.doWork();
        membershipDao.goToSleep();
    }
}
