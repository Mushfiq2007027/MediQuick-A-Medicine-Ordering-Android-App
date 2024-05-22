package com.example.mediquick.Domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LocationTest {

    private Location location;

    @Before
    public void setUp() {
        // Initialize a new Location object before each test
        location = new Location();
    }

    @Test
    public void testSetAndGetId() {
        // Set an ID for the location
        location.setId(1);
        // Check if the ID is set correctly
        assertEquals(1, location.getId());
    }

    @Test
    public void testSetAndGetLoc() {
        // Set a location string for the location
        location.setLoc("New York");
        // Check if the location string is set correctly
        assertEquals("New York", location.getLoc());
    }

    @Test
    public void testToString() {
        // Set a location string for the location
        location.setLoc("San Francisco");
        // Check if the toString method returns the correct string
        assertEquals("San Francisco", location.toString());
    }
}
