package com.example.forintellias.entity.Exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super(MessageFormat.format("Could not find User with id: {0}", id));
    }
}
