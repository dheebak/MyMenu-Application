package com.mymenu.mymenuApplication.customer.impl;

import com.mymenu.mymenuApplication.customer.Customer;
import com.mymenu.mymenuApplication.customer.CustomerRepositoryI;
import com.mymenu.mymenuApplication.customer.CustomerServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceIImpl implements CustomerServiceI {
   // private List<Customer> customers = new ArrayList<>();
    CustomerRepositoryI customerRepositoryI;

    public CustomerServiceIImpl(CustomerRepositoryI customerRepositoryI){
        this.customerRepositoryI = customerRepositoryI;
    }
    @Override
    public List<Customer> findAll() {
        return customerRepositoryI.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepositoryI.save(customer);
    }

    public Customer findByID(Long Id){ return customerRepositoryI.findById(Id).orElse(null);
    }

    @Override
    public boolean deleteById(Long Id) {
        try {
            customerRepositoryI.deleteById(Id);
            return true;
        }catch (Exception e) {
            System.out.println("Customer not found");
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Long id , Customer customer){
        Optional<Customer> customerOptional = customerRepositoryI.findById(id);
        if(customerOptional.isPresent()){
            Customer customerToUpdate = customerOptional.get();
            System.out.println(customerToUpdate.toString());
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setHousename(customer.getHousename());
            customerToUpdate.setPhoneno(customer.getPhoneno());
            customerToUpdate.setAddressid(customer.getAddressid());
            customerToUpdate.setLastOrderDate(customer.getLastOrderDate());
            customerRepositoryI.save(customerToUpdate);
            return true;
        }
        return false;
    }
}

