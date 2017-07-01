package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // TODO: Using POST as I dislike gets for this, even if they are easier...
    @PostMapping("/add/process")
    public String addProcess(
        @Valid @ModelAttribute("customer") Customer customer,
        BindingResult bindingResult,
        final RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "redirect:/customer/add";
        }
        // TODO: TEMP as this example does not include persistence
        redirectAttributes.addAttribute("firstName", customer.getFirstName());
        redirectAttributes.addAttribute("lastName", customer.getLastName());
        redirectAttributes.addAttribute("description", customer.getDescription());
        return "redirect:/customer/add/success";
    }

    @RequestMapping("/add/success")
    public String success(
        @RequestParam(value = "firstName") String firstName,
        @RequestParam(value = "lastName") String lastName,
        @RequestParam(value = "description") String description,
        Model model
    ) {
        model.addAttribute("customer", new Customer(
            firstName,
            lastName,
            description
        ));
        return "customer/add/success";
    }
}
