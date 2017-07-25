package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(
        SessionFactory sessionFactory
    ) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer getCustomerById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer order by lastName").list();
    }

    @Override
    public void saveCustomer(
        Customer customer
    ) {
        Session session = sessionFactory.getCurrentSession();

        session.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.update(customer);
    }
}
