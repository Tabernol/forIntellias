package com.example.forintellias.controller;

import com.example.forintellias.dto.FruitDto;
import com.example.forintellias.dto.UserDTO;
import com.example.forintellias.entity.Fruit;
import com.example.forintellias.entity.User;
import com.example.forintellias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.showUsers();
        List<UserDTO> userDTOList = users.stream().map(UserDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping ("/{id}/bucket")
    public ResponseEntity<List<FruitDto>> showBucket(@PathVariable Long id){
        User user = userService.getUser(id);
        List<Fruit> fruits = user.getUserBucket();
        List<FruitDto> fruitDtoList = fruits.stream().map(FruitDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(fruitDtoList, HttpStatus.OK);
    }
}
