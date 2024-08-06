package com.mymenu.mymenuApplication.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
private final CustomerService customerService;
private Long nextId= 1L;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("/customer")
    public ResponseEntity<String> createJob(@RequestBody Customer customer){
            customer.setId(nextId++);
        customerService.createCustomer(customer);
        return new ResponseEntity<>("Customer added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/customer/{Id}")
    public ResponseEntity<Customer> findJobByID(@PathVariable Long id){
        return customerService.findByID(id)!=null ?
                new ResponseEntity<>(customerService.findByID(id),HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delcust/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        customerService.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }

    @PutMapping("/updatecust/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Customer customer){
        boolean updated = customerService.updateCustomer(id,customer);
        return updated ? new ResponseEntity<>("Updated!",HttpStatus.OK) :
                new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }
}
