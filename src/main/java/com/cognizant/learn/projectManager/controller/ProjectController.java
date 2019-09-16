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
    public Project getProject(@PathVariable long id) {
        Optional<Project> project = projectRepository.findById(id);

        if (!project.isPresent())
            System.out.println("User not found-"+id);
           // throw new Exception("id-" + id);

        return project.get();
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable long id) {
        projectRepository.deleteById(id);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody Project project, @PathVariable long id) {

        Optional<Project> projectOptional = projectRepository.findById(id);

        if (!projectOptional.isPresent())
            return ResponseEntity.notFound().build();

        project.setProjectId(id);

        projectRepository.save(project);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/projects")
    public ResponseEntity<Object> addUser(@RequestBody Project project) {
        Project savedProject = projectRepository.save(project);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProject.getProjectId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
