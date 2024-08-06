package com.mymenu.mymenuApplication.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void createCustomer(Customer customer);

    Customer findByID(Long Id);

    void deleteById(Long Id);

    boolean updateCustomer(Long id, Customer customer);
}
