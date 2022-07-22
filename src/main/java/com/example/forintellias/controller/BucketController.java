package com.example.forintellias.controller;

import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.service.BucketService;
import com.example.forintellias.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bucket")
public class BucketController {

    private final BucketService bucketService;
    private final FruitService fruitService;

    @Autowired
    public BucketController(BucketService bucketService, FruitService fruitService) {
        this.bucketService = bucketService;
        this.fruitService = fruitService;
    }
    @PostMapping("/{userId}/{fruitId}")
    public User buyFruit(@PathVariable Long userId, @PathVariable Long fruitId){
       return bucketService.buyFruit(userId,fruitId);
    }

    @GetMapping("/buyers/{fruitId}")
    public List<User> whoBuyFruit(@PathVariable Long fruitId) {
        Fruit fruit = fruitService.getFruit(fruitId);
        List<User> users = fruit.getBuyer();
        return users;
    }
}
