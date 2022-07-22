package com.example.forintellias.service;

import com.example.forintellias.entity.Exception.UserNotFoundException;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final FruitService fruitService;

    @Autowired
    public UserService(UserRepository userRepository, FruitService fruitService) {
        this.userRepository = userRepository;
        this.fruitService = fruitService;
    }

    public List<User> showUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User buyFruit(Long userId, Long fruitId) {
        User user = getUser(userId);
        Fruit fruit = fruitService.getFruit(fruitId);
        user.getUserBucket().add(fruit);
        return  user;
    }

    public List<Fruit> showBucket(Long userId){
        User user = getUser(userId);
        return user.getUserBucket();
    }

//    public User removeFruit(Long userId, Long fruitId){
//        User user = getUser(userId);
//        Fruit fruit = fruitService.deleteFruit(fruitId);
//        user.removeFruitFromBucket(fruit);
//        return user;
//    }
}
