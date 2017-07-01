package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/")
    public String index() {
        return "customer/list/index";
    }

    @RequestMapping("/add")
    public String add(
        Model model
    ) {
        model.addAttribute("customer", new Customer());
        return "customer/add/index";
    }

    @RequestMapping("/add/process")
    public String addProcess(
        @Valid @ModelAttribute("customer") Customer customer,
        BindingResult bindingResult,
        Model model
    ) {
        model.addAttribute("customer", customer);
        if (bindingResult.hasErrors()) {
            return "customer/add/index";
        }
        return "customer/add/success";
    }
}
