package com.example.recipe.services;

import com.example.recipe.domain.Recipe;
import com.example.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeSet);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);

        // this is to verify that recipeRepo.findAll is called 1 time only
        verify(recipeRepository, times(1)).findAll();
    }
}