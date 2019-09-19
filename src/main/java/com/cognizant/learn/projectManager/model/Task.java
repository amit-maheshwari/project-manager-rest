package com.cognizant.learn.projectManager.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = IDENTITY)
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
    private Date start_date;

    @Temporal(value = TemporalType.DATE)
    @Column (name = "End_Date")
    private Date end_date;
    private int priority;
    private String status;

    @Transient
    private String isEnded;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsEnded() {
        if(end_date == null)
            return "N";
        return end_date.compareTo(new Date(System.currentTimeMillis())) > 0 ? "Y" : "N";
    }
}
