package com.mymenu.mymenuApplication.customer;

import java.util.List;

public interface CustomerServiceI {
    List<Customer> findAll();
    void createCustomer(Customer customer);

    Customer findByID(Long Id);

    boolean deleteById(Long Id);

    boolean updateCustomer(Long id, Customer customer);
}
