package com.cognizant.learn.projectManager.controller;

import com.cognizant.learn.projectManager.model.Project;
import com.cognizant.learn.projectManager.model.User;
import com.cognizant.learn.projectManager.repository.ProjectRepository;
import com.cognizant.learn.projectManager.repository.UserRepository;
import com.cognizant.learn.projectManager.service.ProjectService;
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
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectService.findAll();
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable long id) {
        Optional<Project> project = projectService.findById(id);

        if (!project.isPresent())
            System.out.println("User not found-"+id);
           // throw new Exception("id-" + id);

        return project.get();
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable long id) {
        projectService.delete(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Object> addProject(@RequestBody Project project) {
        Project savedProject = projectService.add(project);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProject.getProjectId()).toUri();

        return ResponseEntity.created(location).build();

    }


    @PutMapping("/projects/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody Project project, @PathVariable Long id) {

        Optional<Project> projectOptional = projectService.update(project, Long.valueOf(id));

        if (!projectOptional.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }


}
