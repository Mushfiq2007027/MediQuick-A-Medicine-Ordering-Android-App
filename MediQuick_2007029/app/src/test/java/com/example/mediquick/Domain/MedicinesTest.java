package com.example.mediquick.Domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MedicinesTest {

    private Medicines medicines;

    @Before
    public void setUp() {
        // Initialize a new Medicines object before each test
        medicines = new Medicines();
    }

    @Test
    public void testSetAndGetCategoryId() {
        // Set a CategoryId for the medicines
        medicines.setCategoryId(101);
        // Check if the CategoryId is set correctly
        assertEquals(101, medicines.getCategoryId());
    }

    @Test
    public void testSetAndGetDescription() {
        // Set a Description for the medicines
        medicines.setDescription("Pain reliever");
        // Check if the Description is set correctly
        assertEquals("Pain reliever", medicines.getDescription());
    }

    @Test
    public void testSetAndIsDiscountMedicine() {
        // Set DiscountMedicine for the medicines
        medicines.setDiscountMedicine(true);
        // Check if DiscountMedicine is set correctly
        assertTrue(medicines.isDiscountMedicine());
    }

    @Test
    public void testSetAndGetId() {
        // Set an Id for the medicines
        medicines.setId(1);
        // Check if the Id is set correctly
        assertEquals(1, medicines.getId());
    }

    @Test
    public void testSetAndGetLocationId() {
        // Set a LocationId for the medicines
        medicines.setLocationId(202);
        // Check if the LocationId is set correctly
        assertEquals(202, medicines.getLocationId());
    }

    @Test
    public void testSetAndGetPrice() {
        // Set a Price for the medicines
        medicines.setPrice(9.99);
        // Check if the Price is set correctly
        assertEquals(9.99, medicines.getPrice(), 0.01);
    }

    @Test
    public void testSetAndGetImagePath() {
        // Set an ImagePath for the medicines
        medicines.setImagePath("path/to/image.jpg");
        // Check if the ImagePath is set correctly
        assertEquals("path/to/image.jpg", medicines.getImagePath());
    }

    @Test
    public void testSetAndGetPriceId() {
        // Set a PriceId for the medicines
        medicines.setPriceId(303);
        // Check if the PriceId is set correctly
        assertEquals(303, medicines.getPriceId());
    }

    @Test
    public void testSetAndGetStar() {
        // Set a Star rating for the medicines
        medicines.setStar(4.5);
        // Check if the Star rating is set correctly
        assertEquals(4.5, medicines.getStar(), 0.01);
    }

    @Test
    public void testSetAndGetTimeId() {
        // Set a TimeId for the medicines
        medicines.setTimeId(404);
        // Check if the TimeId is set correctly
        assertEquals(404, medicines.getTimeId());
    }

    @Test
    public void testSetAndGetTimeValue() {
        // Set a TimeValue for the medicines
        medicines.setTimeValue(5);
        // Check if the TimeValue is set correctly
        assertEquals(5, medicines.getTimeValue());
    }

    @Test
    public void testSetAndGetTitle() {
        // Set a Title for the medicines
        medicines.setTitle("Aspirin");
        // Check if the Title is set correctly
        assertEquals("Aspirin", medicines.getTitle());
    }

    @Test
    public void testSetAndGetNumberInCart() {
        // Set numberInCart for the medicines
        medicines.setNumberInCart(2);
        // Check if numberInCart is set correctly
        assertEquals(2, medicines.getNumberInCart());
    }

    @Test
    public void testToString() {
        // Set a Title for the medicines
        medicines.setTitle("Tylenol");
        // Check if the toString method returns the correct string
        assertEquals("Tylenol", medicines.toString());
    }
}
