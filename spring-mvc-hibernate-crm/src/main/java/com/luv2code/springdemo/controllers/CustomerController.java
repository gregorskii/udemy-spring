package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.entities.Customer;
import com.luv2code.springdemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(
        CustomerService customerService
    ) {
        this.customerService = customerService;
    }

    @RequestMapping()
    public String index(
        Model model
    ) {
        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "customers/index";
    }
}
