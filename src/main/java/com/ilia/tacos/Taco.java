package com.ilia.tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.Date;


import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt = new Date();

    @Size(min=5, message="Name must be at least 5 characters long")
    @NotNull
    private String name;

    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    @ManyToMany(cascade = CascadeType.ALL)
    @Transient
    private List<Ingredient> ingredients;


    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}