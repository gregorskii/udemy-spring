package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + " DOING DB WORK: ADDING AN ACCOUNT " + account.toString());
    }

    @Override
    public boolean isAccount() {
        System.out.println(getClass() + " DOING WORK: CHECKING IF IS ACCOUNT");
        return false;
    }

    @Override
    public boolean doWork() {
        System.out.println("DOING WORK!");
        return false;
    }

    @Override
    public void setAccount(Account account) {
        System.out.println(getClass() + " DOING DB WORK: SETTING AN ACCOUNT " + account.toString());
    }
}
