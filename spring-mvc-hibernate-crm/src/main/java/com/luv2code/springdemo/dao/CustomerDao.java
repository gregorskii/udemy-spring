package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustomerById(String id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
