package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index() {
        accountService.addAccount();

        return "index/index";
    }
}
