package com.example.forintellias.service;

import com.example.forintellias.entity.Exception.FruitNotFoundException;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface FruitServiceIntr {
    public List<Fruit> showFruits();

    public Fruit getFruit(Long id);

    public Fruit saveFruit(Fruit fruit);

    public Fruit deleteFruit(Long id);

    public List<User> whoBuyFruit (Long fruitId);
}
