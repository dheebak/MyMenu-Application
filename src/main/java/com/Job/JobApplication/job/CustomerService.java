package com.Job.JobApplication.job;

import java.util.List;

public interface CustomerService {
    List<Job> findAll();
    void createCustomer(Job job);

    Job findByID(Long Id);

    void deleteById(Long Id);
}
