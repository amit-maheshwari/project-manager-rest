package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

    @Query("select p from ParentTask p where p.task_id = ?1")
    ParentTask findByTask(Long task);
}
