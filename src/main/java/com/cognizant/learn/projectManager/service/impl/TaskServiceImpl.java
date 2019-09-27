package com.cognizant.learn.projectManager.service.impl;

import com.cognizant.learn.projectManager.exception.DuplicateException;
import com.cognizant.learn.projectManager.exception.EntityNotFoundException;
import com.cognizant.learn.projectManager.model.ParentTask;
import com.cognizant.learn.projectManager.model.Task;
import com.cognizant.learn.projectManager.repository.ParentTaskRepository;
import com.cognizant.learn.projectManager.repository.TaskRepository;
import com.cognizant.learn.projectManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ParentTaskRepository parentTaskRepository;

    @Override
    public Task add(Task task) {
        Task taskExists = taskRepository.findByTaskName(task.getTask());
        if(taskExists != null)
                throw new DuplicateException("task.exists",task.getTask());
        if(task.getParentTask() != null && task.getParentTask().getTask_id() != null){
            Long parentTaskId = task.getParentTask().getTask_id();
            if(!taskRepository.findById(parentTaskId).isPresent()){
                throw new EntityNotFoundException("parent.task.not.found",parentTaskId);
            }
            ParentTask parentTask =parentTaskRepository.findByTask(parentTaskId);
            if(parentTask != null){
                task.setParentTask(parentTask);
            }
        }
        /*Optional<ParentTask> parentTask = parentTaskRepository.findById(task.getParentTask().getParent_id());
        if(parentTask.isPresent()){
            task.setParentTask(parentTask.get());*/
            taskRepository.save(task);

        return  task;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Task> update(Task task, Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllParentTask() {
        return taskRepository.findAllParentTasks();
    }

    @Override
    public List<Task> findAllTaskForProject(Long projectId){
        return taskRepository.findTasksByProjectId(projectId);
    }

}
