package com.djh.lunchbox_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class IngredientPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
}
