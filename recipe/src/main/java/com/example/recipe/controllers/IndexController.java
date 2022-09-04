package com.example.recipe.controllers;

import com.example.recipe.domain.Category;
import com.example.recipe.domain.UnitOfMeasure;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Cat ID is: " + categoryOptional.get().getId());
        System.out.println("Unit of measure is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
