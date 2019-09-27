package com.cognizant.learn.projectManager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParentTask {

    @Id
    @GeneratedValue
    @Column(name = "Parent_ID")
    private Long parent_id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentTask")
    @JsonIgnoreProperties("parentTask")
    Set<Task> tasks = new HashSet<>(0);

    @Column(name = "PARENT_TASK", nullable = false)
    Long task_id;

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void addTasks(Task task){
        this.tasks.add(task);
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }
}
