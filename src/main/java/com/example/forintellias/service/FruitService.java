package com.example.forintellias.service;

import com.example.forintellias.entity.Exception.FruitNotFoundException;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FruitService implements FruitServiceIntr{
    private final FruitRepository fruitRepository;


    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> showFruits() {
        return StreamSupport
                .stream(fruitRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Fruit getFruit(Long id) {
        return fruitRepository.findById(id).orElseThrow(()-> new FruitNotFoundException(id));
    }

    public Fruit saveFruit(Fruit fruit) {
        fruitRepository.save(fruit);
        return fruit;
    }

    public Fruit deleteFruit(Long id) {
        Fruit fruit = getFruit(id);
        fruitRepository.delete(fruit);
        return  fruit;
    }

    public List<User> whoBuyFruit (Long fruitId){
        Fruit fruit = getFruit(fruitId);
        return fruit.getBuyer();
    }
}
