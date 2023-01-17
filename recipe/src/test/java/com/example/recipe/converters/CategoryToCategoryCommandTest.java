package com.example.recipe.converters;

import com.example.recipe.command.CategoryCommand;
import com.example.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {
   public static final String DESCRIPTION = "Description";
   public static final Long ID = 1L;
    CategoryToCategoryCommand converter;

    @BeforeEach
    void setUp() {
        converter =  new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws  Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        // given
        Category category = new Category();
        category.setId(ID);
        category.setDescription(DESCRIPTION);

        // when
        CategoryCommand command = converter.convert(category);

        // then
        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescriptions());
    }
}