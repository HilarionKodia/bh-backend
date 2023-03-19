package com.bh.backend.services;

import com.bh.backend.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    public List<Customer> get() {
        return Customer.findAll().list();
    }
}
