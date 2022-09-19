package com.example.recipe.controllers;

import com.example.recipe.domain.Recipe;
import com.example.recipe.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class IndexControllerTest {
    IndexController indexController;
    @Mock
    RecipeServiceImpl recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        // when
        HashSet<Recipe> recipeSet = new HashSet<>();
        Recipe recipe = new Recipe();
        recipeSet.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipeSet);

        // assertions
        assertEquals("index", indexController.getIndexPage(model));
        assertEquals(recipeSet.size(), 1);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}