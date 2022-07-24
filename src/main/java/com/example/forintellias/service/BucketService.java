package com.example.forintellias.service;

import com.example.forintellias.entity.Exception.AmountAboutZero;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BucketService {
    private final UserService userService;
    private final FruitService fruitService;

    @Autowired
    public BucketService(UserService userService, FruitService fruitService) {
        this.userService = userService;
        this.fruitService = fruitService;
    }

    public User buyFruit(Long userId, Long fruitId) {
        Fruit fruit = fruitService.getFruit(fruitId);
        User user = userService.getUser(userId);
        if (user.getUserAmount() >= fruit.getFruitPrice()) {
            user.getUserBucket().add(fruit);
            user.setUserAmount((user.getUserAmount() - fruit.getFruitPrice()));
            System.out.println(user);
            userService.saveUser(user);
            fruit.getBuyer().add(user);
            fruitService.saveFruit(fruit);
        } else {
            throw new AmountAboutZero();
        }
        return user;
    }

//    public void removeFruitFromBucket(Long fruitId) {
//        Fruit fruit = fruitService.getFruit(fruitId);
//        userService.showUsers()
//                .stream()
//                .filter(user -> user.getUserBucket().contains(fruit))
//                .map(user -> user.getUserBucket().remove(fruit));
//
//    }
}
