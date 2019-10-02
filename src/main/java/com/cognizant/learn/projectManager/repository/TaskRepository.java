package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "select count(*) as total, count(status) as completed from (select CASE WHEN status='Completed' THEN 1 END status from task where project_id=?1) task", nativeQuery = true)
    Object[][] findTotalAndCompletedTaskByProject(Long projectId);

    @Query("select t from Task t where t.task = ?1")
    Task findByTaskName(String taskName);

    @Query(value="select * from Task t where t.parent_id is NULL and t.status <> 'Completed'", nativeQuery = true)
    List<Task> findAllParentTasks();

    @Query("select t from Task t where t.project_id = ?1")
    List<Task> findTasksByProjectId(Long projectId);

    @Query("select t from Task t where t.parentTask is null and t.status <> 'Completed' and t.task like  (?1%)")
    List<Task> searchParentTask(String searchString);
}
