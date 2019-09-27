package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.employeeId = ?1")
    User findByEmployeeId(int employee_id);
}
