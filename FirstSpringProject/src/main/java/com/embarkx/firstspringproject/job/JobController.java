package com.embarkx.firstspringproject.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@RequestMapping("/jobs") It creates a base url for all request in the methods i.e not need to write /job everywhere
public class JobController {
    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    private JobService jobservice;
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobservice.findAll(), HttpStatus.OK);
        //return new ResponseEntity(jobs,HttpStatus.OK);
    }
    //@PostMapping("/jobs")
    @RequestMapping(value="/jobs", method = RequestMethod.POST)
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobservice.createJob(job);
        return new ResponseEntity<>("job added successfully",HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(Long id){
        Job job = jobservice.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
    }

    //@DeleteMapping("/jobs/{id}")
    @RequestMapping(value="/jobs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        if(jobservice.deleteJobById(id))
            return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
        else return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
    }

    //@PutMapping("/jobs/{id}")
    @RequestMapping(value="/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobservice.updateJob(id,updatedJob);
        if(updated){
            return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
    }
}
