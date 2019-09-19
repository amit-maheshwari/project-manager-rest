package com.cognizant.learn.projectManager.service;

import com.cognizant.learn.projectManager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(User user);

    void delete(Long id);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> update(User user, Long id);
}
