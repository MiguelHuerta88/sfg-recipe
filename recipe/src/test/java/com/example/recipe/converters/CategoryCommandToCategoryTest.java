package com.example.recipe.converters;

import com.example.recipe.command.CategoryCommand;
import com.example.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    CategoryCommandToCategory converter;

    @BeforeEach
    public void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(1L);
        categoryCommand.setDescriptions("Description");

        // when
        Category category = converter.convert(categoryCommand);

        // then
        assertEquals(1L, category.getId());
        assertEquals("Description", category.getDescription());
    }
}