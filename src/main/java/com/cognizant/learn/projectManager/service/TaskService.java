package com.cognizant.learn.projectManager.service;

import com.cognizant.learn.projectManager.model.ParentTask;
import com.cognizant.learn.projectManager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task add(Task task);

    void delete(Long id);

    List<Task> findAll();

    Optional<Task> findById(Long id);

    Optional<Task> update(Task task, Long id);

    List<Task> findAllParentTask();

    List<Task> findAllTaskForProject(Long projectId);
}
