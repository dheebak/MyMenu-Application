package com.Job.JobApplication.job;

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
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("/customer")
    public ResponseEntity<String> createJob(@RequestBody Job job){
            job.setId(nextId++);
        customerService.createCustomer(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/customer/{Id}")
    public ResponseEntity<Job> findJobByID(@PathVariable Long Id){
        return customerService.findByID(Id)!=null ? new ResponseEntity<>(customerService.findByID(Id),HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delcust/{Id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long Id){
        customerService.deleteById(Id);
        return ResponseEntity.ok("Deleted!");
    }
}
