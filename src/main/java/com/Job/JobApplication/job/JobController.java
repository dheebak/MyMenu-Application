package com.Job.JobApplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
private JobService jobService;
private Long nextId= 1L;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
            job.setId(nextId++);
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{Id}")
    public ResponseEntity<Job> findJobByID(@PathVariable Long Id){
        return jobService.findByID(Id)!=null ? new ResponseEntity<>(jobService.findByID(Id),HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deljob/{Id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long Id){
        jobService.deleteById(Id);
        return ResponseEntity.ok("Deleted!");
    }
}
