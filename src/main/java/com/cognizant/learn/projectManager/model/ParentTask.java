package com.cognizant.learn.projectManager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParentTask {

    @Id
    @GeneratedValue
    @Column(name = "Parent_ID")
    private Long parent_id;

    @OneToMany(mappedBy = "parentTask", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("childTask")
    Set<Task> childTasks = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Parent_Task", referencedColumnName = "Task_ID")
    Task task;


    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Set<Task> getChildTask() {
        return childTasks;
    }

    public void setChildTask(Set<Task> childTasks) {
        this.childTasks = childTasks;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
