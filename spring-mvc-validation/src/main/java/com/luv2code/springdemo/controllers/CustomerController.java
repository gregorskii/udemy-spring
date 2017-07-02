package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.models.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
        // TODO: DEBUG
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/add/index";
        }
        // TODO: TEMP as this example does not include persistence
        redirectAttributes.addAttribute("firstName", customer.getFirstName());
        redirectAttributes.addAttribute("lastName", customer.getLastName());
        redirectAttributes.addAttribute("description", customer.getDescription());
        redirectAttributes.addAttribute("age", customer.getAge());
        redirectAttributes.addAttribute("zipCode", customer.getZipCode());
        redirectAttributes.addAttribute("branch", customer.getBranch());
        return "redirect:/customer/add/success";
    }

    @RequestMapping("/add/success")
    public String success(
        @RequestParam(value = "firstName") String firstName,
        @RequestParam(value = "lastName") String lastName,
        @RequestParam(value = "description") String description,
        @RequestParam(value = "age") String age,
        @RequestParam(value = "zipCode") String zipCode,
        @RequestParam(value = "branch") String branch,
        Model model
    ) {
        model.addAttribute("customer", new Customer(
            firstName,
            lastName,
            description,
            Integer.parseInt(age),
            zipCode,
            branch
        ));
        return "customer/add/success";
    }

    /**
     * Add an initBinder to handle strings that are empty
     *
     * @param dataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
