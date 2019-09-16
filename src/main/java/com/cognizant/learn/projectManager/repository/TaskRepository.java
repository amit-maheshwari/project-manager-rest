package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
