package com.cognizant.learn.projectManager.controller;

import com.cognizant.learn.projectManager.model.Project;
import com.cognizant.learn.projectManager.model.User;
import com.cognizant.learn.projectManager.repository.ProjectRepository;
import com.cognizant.learn.projectManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/fsd")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable long id, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        Optional<Project> project = projectRepository.findById(id);

        if (!project.isPresent())
            System.out.println("User not found-"+id);
           // throw new Exception("id-" + id);

        return project.get();
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable long id, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        projectRepository.deleteById(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Object> addProject(@RequestBody Project project, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        Project savedProject = projectRepository.save(project);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProject.getProjectId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
