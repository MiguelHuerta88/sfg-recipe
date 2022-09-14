package com.example.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"recipe"})
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // no cascade since the Recipe is the owner
    @OneToOne
    private Recipe recipe;

    // to allow large strings past 255
    @Lob
    private String recipeNotes;
}
