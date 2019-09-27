package com.cognizant.learn.projectManager.controller;

import com.cognizant.learn.projectManager.model.User;
import com.cognizant.learn.projectManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/fsd")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        Optional<User> user = userService.findById(id);

        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) {

        Optional<User> userOptional = userService.update(user, Long.valueOf(id));

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        User savedUser = userService.add(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUser_Id()).toUri();

        return ResponseEntity.created(location).build();

    }
}
