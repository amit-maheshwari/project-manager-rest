package com.cognizant.learn.projectManager.repository;

import com.cognizant.learn.projectManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
