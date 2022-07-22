package com.example.forintellias.controller;

import com.example.forintellias.dto.FruitDto;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.repository.FruitRepository;
import com.example.forintellias.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public ResponseEntity<List<FruitDto>> getAllFruits() {
        List<Fruit> fruits = fruitService.showFruits();
        List<FruitDto> fruitDtoList = fruits.stream().map(FruitDto::from).collect(Collectors.toList());
        return new ResponseEntity<> (fruitDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable long id) {
        return fruitService.getFruit(id);
    }

    @PostMapping
    public Fruit saveFruit(@RequestBody Fruit fruit) {
        return fruitService.saveFruit(fruit);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
    }

    @GetMapping("/{fruitId}/buyers")
    public List<User> whoBuyFruit(@PathVariable Long fruitId) {
        return fruitService.whoBuyFruit(fruitId);
    }
}
