package com.example.forintellias.service;

import com.example.forintellias.entity.Exception.UserNotFoundException;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserServiceIntr{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Fruit> showBucket(Long userId){
        User user = getUser(userId);
        return user.getUserBucket();
    }
}
