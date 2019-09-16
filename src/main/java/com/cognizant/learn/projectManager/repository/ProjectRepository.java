package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
