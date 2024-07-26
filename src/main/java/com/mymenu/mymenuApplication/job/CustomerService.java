package com.mymenu.mymenuApplication.job;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void createCustomer(Customer customer);

    Customer findByID(Long Id);

    void deleteById(Long Id);
}
