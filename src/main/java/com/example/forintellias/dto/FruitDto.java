package com.example.forintellias.dto;

import com.example.forintellias.entity.Fruit;
import lombok.Data;

@Data
public class FruitDto {
    private String fruitName;
    private double fruitPrice;

    public static FruitDto from (Fruit fruit){
        FruitDto fruitDto = new FruitDto();
        fruitDto.setFruitName(fruit.getFruitName());
        fruitDto.setFruitPrice(fruit.getFruitPrice());
        return fruitDto;
    }
}
