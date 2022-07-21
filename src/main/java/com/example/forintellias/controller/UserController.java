package com.example.forintellias.controller;

import com.example.forintellias.entity.User;
import com.example.forintellias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.showUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
