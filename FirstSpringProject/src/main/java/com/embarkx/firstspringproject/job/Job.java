package com.embarkx.firstspringproject.job;

import org.jetbrains.annotations.NotNull;

public class Job {
    private Long id;

    public Long getId() {
        //@NotNull(message = "Name cannot be null")
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getLocation() {
        return location;
    }

    private String title;
    private String description;
    private String minSalary;
    private String location;

    public Job(Long id, String title, String description, String minSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.location = location;
    }
}
