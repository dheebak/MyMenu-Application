package com.Job.JobApplication.job.impl;

import com.Job.JobApplication.job.Job;
import com.Job.JobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    public Job findByID(Long Id){ return jobs.stream()
            .filter(job -> job.getId() == Id)
            .findAny()
            .orElse(null);
    }

    @Override
    public void deleteById(Long Id) {
        Job jobDel = jobs.stream().filter(job -> Objects.equals(job.getId(), Id)).findAny().orElse(null);
    }
}

