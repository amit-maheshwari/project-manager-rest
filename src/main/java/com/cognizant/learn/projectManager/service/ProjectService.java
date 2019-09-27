package com.cognizant.learn.projectManager.service;

import com.cognizant.learn.projectManager.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project add(Project project);

    void delete(Long id);

    List<Project> findAll();

    Optional<Project> findById(Long id);

    Optional<Project> update(Project user, Long id);
}
