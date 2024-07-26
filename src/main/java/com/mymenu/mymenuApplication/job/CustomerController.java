package com.mymenu.mymenuApplication.job;

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
    public ResponseEntity<Customer> findJobByID(@PathVariable Long Id){
        return customerService.findByID(Id)!=null ? new ResponseEntity<>(customerService.findByID(Id),HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delcust/{Id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long Id){
        customerService.deleteById(Id);
        return ResponseEntity.ok("Deleted!");
    }
}
