package com.cognizant.learn.projectManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column (name = "User_ID")
    private Long user_Id;
    @Column (name = "First_Name", nullable = false)
    private String firstName;
    @Column (name = "Last_Name", nullable = false)
    private String lastName;
    @Column (name = "Employee_ID", nullable = false)
    private int employeeId;
    @Column (name = "Project_ID")
    private Long project_Id;
    @Column (name = "Task_ID")
    private Long task_id;

    public User(){}

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(Long project_Id) {
        this.project_Id = project_Id;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }
}
