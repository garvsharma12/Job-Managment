package com.embarkx.firstspringproject.job;
import java.util.*;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
