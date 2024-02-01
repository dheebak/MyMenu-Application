package com.Job.JobApplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job findByID(Long Id);

    void deleteById(Long Id);
}
