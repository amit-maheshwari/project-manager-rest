package com.cognizant.learn.projectManager.service.impl;

import com.cognizant.learn.projectManager.exception.DuplicateException;
import com.cognizant.learn.projectManager.exception.EntityNotFoundException;
import com.cognizant.learn.projectManager.model.ParentTask;
import com.cognizant.learn.projectManager.model.Task;
import com.cognizant.learn.projectManager.model.User;
import com.cognizant.learn.projectManager.repository.ParentTaskRepository;
import com.cognizant.learn.projectManager.repository.TaskRepository;
import com.cognizant.learn.projectManager.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public Task add(Task task) {
        Task taskExists = taskRepository.findByTaskName(task.getTask());
        if(taskExists != null)
                throw new DuplicateException("task.exists",task.getTask());
        if(task.getParentTask() != null && task.getParentTask().getTask().getTask_id() != null){
            Long parentTaskId = task.getParentTask().getTask().getTask_id();
            if(!taskRepository.findById(parentTaskId).isPresent()){
                throw new EntityNotFoundException("parent.task.not.found",parentTaskId);
            }
            ParentTask parentTask =parentTaskRepository.findByTask(parentTaskId);
            if(parentTask != null){
                task.setParentTask(parentTask);
            }
            taskRepository.save(task);
        }else{
            taskRepository.save(task);
            ParentTask pt = new ParentTask();
            pt.setTask(task);
            parentTaskRepository.save(pt);
        }
        if(task.getParentTask() != null) {
            User user = task.getUser();
            user.setTask_id(task.getTask_id());
            userRepository.save(user);
        }
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
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(!taskOptional.isPresent())
            return  taskOptional;
        task.setTask_id(id);
        taskRepository.save(task);
        if(task.isCompleted()){
            userRepository.updateTaskId(task.getTask_id());
        }
        return Optional.of(task);
    }

    @Override
    public List<ParentTask> findAllParentTask() {
        return parentTaskRepository.findAll();
    }

    @Override
    public List<Task> findAllTaskForProject(Long projectId){
        return taskRepository.findTasksByProjectId(projectId);
    }


}
