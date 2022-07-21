package com.example.forintellias.service;

import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> showFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruit(long id) {
        return fruitRepository.findById(id).get();
    }

    public Fruit saveFruit(Fruit fruit) {
        fruitRepository.save(fruit);
        return fruit;
    }

    public void deleteFruit(long id) {
        fruitRepository.deleteById(id);
    }
}
