package com.cognizant.learn.projectManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue
    @Column (name = "Project_ID")
    private Long project_Id;
    @Column (name = "Project", nullable = false)
    private String project;
    @Column (name = " Start_Date")
    private Date start_date;
    @Column (name= "End_Date")
    private Date end_date;
    private int priority;

    public Project(){};

    public Long getProjectId() {
        return project_Id;
    }

    public void setProjectId(Long projectId) {
        this.project_Id = projectId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
