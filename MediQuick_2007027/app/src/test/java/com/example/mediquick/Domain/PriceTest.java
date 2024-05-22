package com.example.mediquick.Domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PriceTest {

    private Price price;

    @Before
    public void setUp() {
        // Initialize a new Price object before each test
        price = new Price();
    }

    @Test
    public void testSetAndGetId() {
        // Set an Id for the price
        price.setId(1);
        // Check if the Id is set correctly
        assertEquals(1, price.getId());
    }

    @Test
    public void testSetAndGetValue() {
        // Set a Value for the price
        price.setValue("10.99 USD");
        // Check if the Value is set correctly
        assertEquals("10.99 USD", price.getValue());
    }

    @Test
    public void testToString() {
        // Set a Value for the price
        price.setValue("15.99 USD");
        // Check if the toString method returns the correct string
        assertEquals("15.99 USD", price.toString());
    }
}
