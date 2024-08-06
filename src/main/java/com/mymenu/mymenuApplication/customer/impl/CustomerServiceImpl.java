package com.mymenu.mymenuApplication.customer.impl;

import com.mymenu.mymenuApplication.customer.Customer;
import com.mymenu.mymenuApplication.customer.CustomerService;
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

    @Override
    public boolean updateCustomer(Long id , Customer customer){
        Customer customerToUpdate = customers.stream().filter(cust  -> cust.getId().equals(id)).findAny().orElse(null);
        if(customerToUpdate!=null){
            System.out.println(customerToUpdate.toString());
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setHousename(customer.getHousename());
            customerToUpdate.setPhoneno(customer.getPhoneno());
            customerToUpdate.setAddressid(customer.getAddressid());
            customerToUpdate.setLastOrderDate(customer.getLastOrderDate());
            return true;
        }
        return false;
    }
}

