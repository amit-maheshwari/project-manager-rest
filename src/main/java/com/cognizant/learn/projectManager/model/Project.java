package com.cognizant.learn.projectManager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue
    @Column (name = "Project_ID")
    private Long project_Id;

    @Column (name = "Project", nullable = false)
    private String project;

    @Temporal(value = TemporalType.DATE)
    @Column (name = " Start_Date")
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    @Column (name= "End_Date")
    private Date endDate;

    private int priority;

    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "Manager_ID", referencedColumnName = "User_ID")
    @NotNull
    private User manager;

    @Transient
    private int totalTask;
    @Transient
    private int completedTask;

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

    public Long getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(Long project_Id) {
        this.project_Id = project_Id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /*public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }*/

    public int getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(int totalTask) {
        this.totalTask = totalTask;
    }

    public int getCompletedTask() {
        return completedTask;
    }

    public void setCompletedTask(int completedTask) {
        this.completedTask = completedTask;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
