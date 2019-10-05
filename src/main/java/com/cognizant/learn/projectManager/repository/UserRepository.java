package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.employeeId = ?1")
    User findByEmployeeId(int employee_id);

    @Transactional
    @Modifying
    @Query("Update User c set c.task_id=null where task_id= ?1")
    int updateTaskId(Long task_id);

}
