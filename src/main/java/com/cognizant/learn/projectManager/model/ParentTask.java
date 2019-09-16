package com.cognizant.learn.projectManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParentTask {

    @Id
    @GeneratedValue
    @Column(name = "Parent_ID")
    private Long parent_id;
    private String parent_task;

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_task() {
        return parent_task;
    }

    public void setParent_task(String parent_task) {
        this.parent_task = parent_task;
    }
}
