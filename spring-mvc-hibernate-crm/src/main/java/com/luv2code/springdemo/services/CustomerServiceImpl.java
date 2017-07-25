package com.luv2code.springdemo.services;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(
        CustomerDao customerDao
    ) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public Customer getCustomerById(String id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(
        Customer customer
    ) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}
