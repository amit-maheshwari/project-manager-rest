package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

    @Query(value="select * from parent_task p where p.Parent_Task = ?1", nativeQuery = true)
    ParentTask findByTask(Long task);

}
