package com.cognizant.learn.projectManager.service.impl;

import com.cognizant.learn.projectManager.exception.DuplicateException;
import com.cognizant.learn.projectManager.model.User;
import com.cognizant.learn.projectManager.repository.UserRepository;
import com.cognizant.learn.projectManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        User userExists = userRepository.findByEmployeeId(user.getEmployeeId());
        if(userExists != null)
            throw new DuplicateException("user.exists",String.valueOf(user.getEmployeeId()));
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> update(User user, Long id) {
       Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent())
            return  userOptional;
        user.setUser_Id(id);
        userRepository.save(user);
        return Optional.of(user);
    }

}
