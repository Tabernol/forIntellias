package com.example.forintellias.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long fruitId;

    @NotNull
    private String fruitName;

    @NotNull
    private double fruitPrice;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "Fruit_User",
            joinColumns = @JoinColumn(name = "fruit_id"),
            inverseJoinColumns = @JoinColumn(name = "User_id"))
    private List<User> buyer;

}

