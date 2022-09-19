package com.example.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long id = 4l;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    void getDescription() {
        String description = "This is a sample description";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }
}