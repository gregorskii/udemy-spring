package com.luv2code.springdemo.services;

import com.luv2code.springdemo.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(String id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
