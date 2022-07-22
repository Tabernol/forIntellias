package com.example.forintellias.entity.Exception;

import java.text.MessageFormat;

public class FruitNotFoundException extends RuntimeException{
    public FruitNotFoundException(Long id){
        super(MessageFormat.format("Could not find fruit with id: {0}", id));
    }
}
