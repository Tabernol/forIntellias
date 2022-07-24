package com.example.forintellias.entity.Exception;

import java.text.MessageFormat;

public class AmountAboutZero extends RuntimeException{

    public AmountAboutZero(){
        super(MessageFormat.format("you don't have enough money", false));
    }
}
