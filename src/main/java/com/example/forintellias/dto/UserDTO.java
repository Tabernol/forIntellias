package com.example.forintellias.dto;

import com.example.forintellias.entity.User;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private double amount;

    public static UserDTO from (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getUserName());
        userDTO.setSurname(user.getUserSurname());
        userDTO.setAmount(user.getUserAmount());
        return userDTO;
    }

}
