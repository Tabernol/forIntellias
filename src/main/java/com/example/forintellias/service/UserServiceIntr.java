package com.example.forintellias.service;

import com.example.forintellias.entity.Exception.UserNotFoundException;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface UserServiceIntr {
    public List<User> showUsers();

    public User getUser(Long id);

    public User saveUser(User user);

    public void deleteUser(Long id);

    public List<Fruit> showBucket(Long userId);
}
