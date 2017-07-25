package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.entities.Customer;
import com.luv2code.springdemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(
        CustomerService customerService
    ) {
        this.customerService = customerService;
    }

    @GetMapping()
    public String index(
        Model model
    ) {
        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "customers/index";
    }

    @GetMapping("/add")
    public String add(
        Model model
    ) {
        model.addAttribute("customer", new Customer());
        return "customers/add/index";
    }

    @PostMapping("/add/process")
    public String addProcess(
        @Valid @ModelAttribute("customer") Customer customer,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "customers/add/index";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/update")
    public String update(
        @RequestParam(value = "customerId") String id,
        Model model
    ) {
        model.addAttribute("customer", customerService.getCustomerById(id));

        return "customers/update/index";
    }

    // TODO: could reuse add/process, but left as own method
    @PostMapping("/update/process")
    public String updateProcess(
        @Valid @ModelAttribute("customer") Customer customer,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "customers/update/index";
        }

        System.out.println(customer.toString());

        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/delete/process")
    public String deleteProcess(
        @RequestParam(value = "customerId") String id
    ) {
        customerService.deleteCustomer(id);

        return "redirect:/customers";
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
