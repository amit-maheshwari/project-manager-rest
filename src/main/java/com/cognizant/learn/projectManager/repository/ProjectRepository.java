package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("select p from Project p where p.project = ?1")
    Project findByProjectName(String project);
}
