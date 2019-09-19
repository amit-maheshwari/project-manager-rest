package com.cognizant.learn.projectManager.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "Project_ID")
    private Long project_Id;

    @Column (name = "Project", nullable = false)
    private String project;

    @Temporal(value = TemporalType.DATE)
    @Column (name = " Start_Date")
    private Date start_date;

    @Temporal(value = TemporalType.DATE)
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
