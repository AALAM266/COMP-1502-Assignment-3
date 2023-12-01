package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Figures;

/**
 * This JUnit test class tests the constructor and toString method of the Figures class
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
class FigureTest {

    /**
     * This method tests the constructor and toString method of the Figures class
     */
    @Test
    public void testConstructorAndToStringMethod() {

        Figures figure = new Figures("1024162826", "japanese traditional dolls", "game demon", 139.99, 12, 7, "Figure", "h");

        assertEquals("1024162826", figure.getSerialNumber());
        assertEquals("japanese traditional dolls", figure.getName());
        assertEquals("game demon", figure.getBrand());
        assertEquals(139.99, figure.getPrice()); 
        assertEquals(12, figure.getAvailabityCount());
        assertEquals(7, figure.getAppropriateAge());
        assertEquals("Figure", figure.getToyType());
        assertEquals("h", figure.getClassification());

        String expectedToString = "Category: Figure, Serial Number: 1024162826, Name: japanese traditional dolls, Brand: game demon, Price: 139.99, Available Count: 12, Age Appropriate: 7, Classification: h";
        assertEquals(expectedToString, figure.toString());

    }
}
