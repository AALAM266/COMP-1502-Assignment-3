package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Puzzles;

/**
 * This JUnit test class tests the constructor and toString method of the Puzzles class
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
class PuzzleTest {
	
    /**
     * This method tests the constructor and toString method of the Puzzles class
     */
    @Test
    public void testConstructorAndToStringMethod() {

        Puzzles puzzle = new Puzzles("5726898779", "pocket cube", "game orc", 42.83, 1, 4, "Puzzle", "m");

        
        assertEquals("5726898779", puzzle.getSerialNumber());
        assertEquals("pocket cube", puzzle.getName());
        assertEquals("game orc", puzzle.getBrand());
        assertEquals(42.83, puzzle.getPrice()); 
        assertEquals(1, puzzle.getAvailabityCount());
        assertEquals(4, puzzle.getAppropriateAge());
        assertEquals("Puzzle", puzzle.getToyType());
        assertEquals("m", puzzle.getPuzzleType());


        String expectedToString = "Category: Puzzle, Serial Number: 5726898779, Name: pocket cube, Brand: game orc, Price: 42.83, Available Count: 1, Age Appropriate: 4, Puzzle Type: m";
        assertEquals(expectedToString, puzzle.toString());
    }
}

