package com.mymenu.mymenuApplication.job.impl;

import com.mymenu.mymenuApplication.job.Customer;
import com.mymenu.mymenuApplication.job.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<>();
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findByID(Long Id){ return customers.stream()
            .filter(customer -> Objects.equals(customer.getId(), Id))
            .findAny()
            .orElse(null);
    }

    @Override
    public void deleteById(Long Id) {
        Customer customerDel = customers.stream().filter(customer -> Objects.equals(customer.getId(), Id)).findAny().orElse(null);
    }
}

