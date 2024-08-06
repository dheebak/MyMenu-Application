package com.mymenu.mymenuApplication.customer;

import com.mymenu.mymenuApplication.customer.Customer;
import com.mymenu.mymenuApplication.customer.CustomerServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
private final CustomerServiceI customerServiceI;
    public CustomerController(CustomerServiceI customerServiceI) {
        this.customerServiceI = customerServiceI;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerServiceI.findAll());
    }

    @PostMapping("/customer")
    public ResponseEntity<String> createJob(@RequestBody Customer customer){
        customerServiceI.createCustomer(customer);
        return new ResponseEntity<>("Customer added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/customer/{Id}")
    public ResponseEntity<Customer> findJobByID(@PathVariable Long id){
        return customerServiceI.findByID(id)!=null ?
                new ResponseEntity<>(customerServiceI.findByID(id),HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delcust/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = customerServiceI.deleteById(id);
        return deleted ? ResponseEntity.ok("Deleted!") : ResponseEntity.notFound().build();
    }

    @PutMapping("/updatecust/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Customer customer){
        boolean updated = customerServiceI.updateCustomer(id,customer);
        return updated ? new ResponseEntity<>("Updated!",HttpStatus.OK) :
                new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }
}
