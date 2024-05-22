package com.example.mediquick.Domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TimeTest {

    private Time time;

    @Before
    public void setUp() {
        // Initialize a new Time object before each test
        time = new Time();
    }

    @Test
    public void testSetAndGetId() {
        // Set an Id for the time
        time.setId(1);
        // Check if the Id is set correctly
        assertEquals(1, time.getId());
    }

    @Test
    public void testSetAndGetValue() {
        // Set a Value for the time
        time.setValue("08:00 AM");
        // Check if the Value is set correctly
        assertEquals("08:00 AM", time.getValue());
    }

    @Test
    public void testToString() {
        // Set a Value for the time
        time.setValue("06:00 PM");
        // Check if the toString method returns the correct string
        assertEquals("06:00 PM", time.toString());
    }
}
