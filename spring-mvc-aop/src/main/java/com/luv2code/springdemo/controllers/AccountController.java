package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.entities.Account;
import com.luv2code.springdemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(
        AccountService accountService
    ) {
        this.accountService = accountService;
    }

    @RequestMapping("")
    public String index(
        Model model
    ) {
        Account account = new Account("Gold", "Greg");
        accountService.addAccount();

        ArrayList<Account> accounts = new ArrayList<>();

        accounts.add(account);

        model.addAttribute("accounts", accounts);

        return "account/index";
    }
}
