package com.example.mediquick.Domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        // Initialize a new Category object before each test
        category = new Category();
    }

    @Test
    public void testSetAndGetId() {
        // Set an ID for the category
        category.setId(1);
        // Check if the ID is set correctly
        assertEquals(1, category.getId());
    }

    @Test
    public void testSetAndGetImagePath() {
        // Set an image path for the category
        category.setImagePath("path/to/image.jpg");
        // Check if the image path is set correctly
        assertEquals("path/to/image.jpg", category.getImagePath());
    }

    @Test
    public void testSetAndGetName() {
        // Set a name for the category
        category.setName("Test Category");
        // Check if the name is set correctly
        assertEquals("Test Category", category.getName());
    }
}
