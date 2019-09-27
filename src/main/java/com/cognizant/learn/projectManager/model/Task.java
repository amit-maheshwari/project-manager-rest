package com.cognizant.learn.projectManager.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Task {

    @Id
    @GeneratedValue
    @Column (name = "Task_ID")
    private Long task_id;

    @JoinColumn(name = "Parent_ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    ParentTask parentTask;

    @Column (name = "Project_ID")
    private Long project_id;

    @Column(name = "Task", unique = true, nullable = false, length = 20)
    private String task;

    @Temporal(value = TemporalType.DATE)
    @Column (name = "Start_Date")
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    @Column (name = "End_Date")
    private Date endDate;
    private int priority;
    @Column(name = "status", nullable = false)
    private String status = "Started";


    public Task(){};

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public ParentTask getParentTask() {
        return parentTask;
    }

    public void setParentTask(ParentTask parentTask) {
        this.parentTask = parentTask;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
