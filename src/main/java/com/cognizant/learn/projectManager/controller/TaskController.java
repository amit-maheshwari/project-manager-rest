package com.cognizant.learn.projectManager.controller;

import com.cognizant.learn.projectManager.model.ParentTask;
import com.cognizant.learn.projectManager.model.Task;
import com.cognizant.learn.projectManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/fsd")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable long id) {
        Optional<Task> task = taskService.findById(id);

        return task.get();
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteUser(@PathVariable long id) {
        taskService.delete(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable long id) {

        Optional<Task> taskOptional = taskService.update(task, id);

        if (!taskOptional.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Object> addTask(@RequestBody Task task) {
        Task savedTask = taskService.add(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTask.getTask_id()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/tasks/project/{id}")
    public List<Task> getTasksForProject( @PathVariable long id){
        return taskService.findAllTaskForProject(id);
    }

    @GetMapping("/parentTasks")
    public List<ParentTask> getTasksForProject(){
        return taskService.findAllParentTask();
    }



}
