package com.example.mediquick.Domain;



import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DomainInstrumentedTest {

    private Category category;
    private Location location;
    private Medicines medicines;
    private Price price;
    private Time time;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();

        // Initialize all objects before each test
        category = new Category();
        location = new Location();
        medicines = new Medicines();
        price = new Price();
        time = new Time();
    }

    // Test methods for Category class
    @Test
    public void testCategory() {
        category.setId(1);
        assertEquals(1, category.getId());

        category.setImagePath("path/to/image.jpg");
        assertEquals("path/to/image.jpg", category.getImagePath());

        category.setName("Medicine");
        assertEquals("Medicine", category.getName());
    }

    // Test methods for Location class
    @Test
    public void testLocation() {
        location.setId(1);
        assertEquals(1, location.getId());

        location.setLoc("New York");
        assertEquals("New York", location.getLoc());

        location.setLoc("Los Angeles");
        assertEquals("Los Angeles", location.toString());
    }

    // Test methods for Medicines class
    @Test
    public void testMedicines() {
        medicines.setCategoryId(101);
        assertEquals(101, medicines.getCategoryId());

        medicines.setDescription("Pain reliever");
        assertEquals("Pain reliever", medicines.getDescription());

        medicines.setDiscountMedicine(true);
        assertTrue(medicines.isDiscountMedicine());

        medicines.setId(1);
        assertEquals(1, medicines.getId());

        medicines.setLocationId(202);
        assertEquals(202, medicines.getLocationId());

        medicines.setPrice(9.99);
        assertEquals(9.99, medicines.getPrice(), 0.01);

        medicines.setImagePath("path/to/image.jpg");
        assertEquals("path/to/image.jpg", medicines.getImagePath());

        medicines.setPriceId(303);
        assertEquals(303, medicines.getPriceId());

        medicines.setStar(4.5);
        assertEquals(4.5, medicines.getStar(), 0.01);

        medicines.setTimeId(404);
        assertEquals(404, medicines.getTimeId());

        medicines.setTimeValue(5);
        assertEquals(5, medicines.getTimeValue());

        medicines.setTitle("Aspirin");
        assertEquals("Aspirin", medicines.getTitle());

        medicines.setNumberInCart(2);
        assertEquals(2, medicines.getNumberInCart());

        medicines.setTitle("Tylenol");
        assertEquals("Tylenol", medicines.toString());
    }

    // Test methods for Price class
    @Test
    public void testPrice() {
        price.setId(1);
        assertEquals(1, price.getId());

        price.setValue("10.99 USD");
        assertEquals("10.99 USD", price.getValue());

        price.setValue("15.99 USD");
        assertEquals("15.99 USD", price.toString());
    }

    // Test methods for Time class
    @Test
    public void testTime() {
        time.setId(1);
        assertEquals(1, time.getId());

        time.setValue("08:00 AM");
        assertEquals("08:00 AM", time.getValue());

        time.setValue("06:00 PM");
        assertEquals("06:00 PM", time.toString());
    }
}
