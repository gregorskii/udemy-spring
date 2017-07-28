package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void setAccount(Account account) {
        System.out.println(getClass() + " DOING DB WORK: SETTING AN ACCOUNT " + account.toString());
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();

        Account ac1 = new Account("gold", "bob");
        Account ac2 = new Account("silver", "albert");
        Account ac3 = new Account("bronze", "george");

        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);

        return accounts;
    }

    @Override
    public void runException() throws Exception {
        throw new Exception("An Exception!");
    }
}
