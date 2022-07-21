package com.example.forintellias.controller;

import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.repository.FruitRepository;
import com.example.forintellias.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAllFruits() {
        return fruitService.showFruits();
    }

    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable long id) {
        return fruitService.getFruit(id);
    }

    @PostMapping
    public void saveFruit(@RequestBody Fruit fruit) {
        fruitService.saveFruit(fruit);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable long id) {
        fruitService.deleteFruit(id);
    }
}
