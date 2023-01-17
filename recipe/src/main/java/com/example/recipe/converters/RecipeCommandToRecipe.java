package com.example.recipe.converters;

import com.example.recipe.command.RecipeCommand;
import com.example.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final NotesCommandToNotes notesCommandToNotes;
    private final CategoryCommandToCategory categoryCommandToCategory;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient, NotesCommandToNotes notesCommandToNotes, CategoryCommandToCategory categoryCommandToCategory) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.notesCommandToNotes = notesCommandToNotes;
        this.categoryCommandToCategory = categoryCommandToCategory;
    }

    public Recipe convert(RecipeCommand source) {
        if (source == null) return null;

        Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setNotes(notesCommandToNotes.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach(category -> recipe.getCategories().add(categoryCommandToCategory.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredient)));
        }


        return recipe;
    }
}
