package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Animals;

/**
 * This JUnit test class tests the constructor and toString method of the Animals class
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
class AnimalTest {

    /**
     * This method tests the constructor and toString method of the Animals class
     */
    @Test
    public void testConstructorAndToStringMethod() {
        Animals animal = new Animals("2296386544", "chimpanzee", "gamefluent", 12.89, 12, 10, "Animal", "fabric", "l");

        assertEquals("2296386544", animal.getSerialNumber());
        assertEquals("chimpanzee", animal.getName());
        assertEquals("gamefluent", animal.getBrand());
        assertEquals(12.89, animal.getPrice()); 
        assertEquals(12, animal.getAvailabityCount());
        assertEquals(10, animal.getAppropriateAge());
        assertEquals("Animal", animal.getToyType()); 
        assertEquals("fabric", animal.getMaterial());
        assertEquals("l", animal.getSize());

        
        String expectedToString = "Category: Animal, Serial Number: 2296386544, Name: chimpanzee, Brand: gamefluent, Price: 12.89, Available Count: 12, Age Appropriate: 10, Material: fabric, Size: l";
        assertEquals(expectedToString, animal.toString());
    }
}

